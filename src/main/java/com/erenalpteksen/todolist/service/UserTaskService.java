package com.erenalpteksen.todolist.service;

import com.erenalpteksen.todolist.dto.TaskDTO;
import com.erenalpteksen.todolist.entity.User;

import java.util.List;

public interface UserTaskService {
    User getUserById(Long userId);
    List<TaskDTO> getTasksByUserId(Long userId);
}
