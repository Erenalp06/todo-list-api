package com.erenalpteksen.todolist.exception;

import com.erenalpteksen.todolist.exception.custom.TaskNotFoundException;
import com.erenalpteksen.todolist.exception.custom.UserNotFoundException;
import com.erenalpteksen.todolist.exception.response.DefaultResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
@RestController
public class CustomizedHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request)
    {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }



        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .timestamp(new Date())
                .message("Validation failed")
                .errors(errors)
                .build();

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<DefaultResponse> handleNotFoundException(UserNotFoundException ex){
        String errorMessage = "User not found with id";
        String exceptionType = ex.getClass().getSimpleName();
        Integer status = HttpStatus.NOT_FOUND.value();

        return new ResponseEntity<>(createResponse(errorMessage, exceptionType, status), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<DefaultResponse> handleNotFoundException(TaskNotFoundException ex){
        String errorMessage = "Task not found with id";
        String exceptionType = ex.getClass().getSimpleName();
        Integer status = HttpStatus.NOT_FOUND.value();

        return new ResponseEntity<>(createResponse(errorMessage, exceptionType, status), HttpStatus.NOT_FOUND);
    }

    private DefaultResponse createResponse(String errorMessage, String exType, Integer status){
        return DefaultResponse.builder()
                .status(status)
                .message(errorMessage)
                .exceptionType(exType)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
    }


}
