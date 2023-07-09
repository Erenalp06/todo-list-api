package com.erenalpteksen.todolist.controller;

import com.erenalpteksen.todolist.dto.TaskDTO;
import com.erenalpteksen.todolist.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<TaskDTO>> findAllByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(taskService.findAllByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@Valid @RequestBody TaskDTO taskDTO){
        return ResponseEntity.ok(taskService.add(taskDTO));
    }

    @PutMapping
    public ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO taskDTO){
        return ResponseEntity.ok(taskService.update(taskDTO));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskId){
        return ResponseEntity.ok(taskService.deleteById(taskId));
    }


}
