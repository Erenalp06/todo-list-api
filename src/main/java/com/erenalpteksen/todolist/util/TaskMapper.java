package com.erenalpteksen.todolist.util;

import com.erenalpteksen.todolist.dto.TaskDTO;
import com.erenalpteksen.todolist.entity.Task;
import com.erenalpteksen.todolist.entity.User;
import com.erenalpteksen.todolist.service.UserService;

public class TaskMapper {

    public static TaskDTO toDTO(Task task){
        return TaskDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .completed(task.getCompleted())
                .userId(task.getUser().getId())
                .build();
    }

    public static Task toEntity(TaskDTO taskDTO, User user) {

        return Task.builder()
                .id(taskDTO.getId())
                .title(taskDTO.getTitle())
                .description(taskDTO.getDescription())
                .completed(taskDTO.getCompleted())
                .user(user)
                .build();
    }
}
