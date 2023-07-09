package com.erenalpteksen.todolist.service;

import com.erenalpteksen.todolist.dto.TaskDTO;
import com.erenalpteksen.todolist.entity.User;
import com.erenalpteksen.todolist.exception.custom.UserNotFoundException;
import com.erenalpteksen.todolist.repository.TaskRepository;
import com.erenalpteksen.todolist.repository.UserRepository;
import com.erenalpteksen.todolist.util.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskUserService implements UserTaskService{

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public TaskUserService(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<TaskDTO> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId).stream()
                .map(TaskMapper::toDTO)
                .collect(Collectors.toList());
    }
}
