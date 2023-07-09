package com.erenalpteksen.todolist.exception.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DefaultResponse {
    private int status;
    private String exceptionType;
    private String message;
    private Timestamp timestamp;
}
