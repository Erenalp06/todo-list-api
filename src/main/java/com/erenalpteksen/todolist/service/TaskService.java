package com.erenalpteksen.todolist.service;

import com.erenalpteksen.todolist.dto.TaskDTO;
import com.erenalpteksen.todolist.entity.Task;
import com.erenalpteksen.todolist.entity.User;
import com.erenalpteksen.todolist.exception.custom.TaskNotFoundException;
import com.erenalpteksen.todolist.repository.TaskRepository;
import com.erenalpteksen.todolist.util.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserTaskService userTaskService;

    public List<TaskDTO> findAllByUserId(Long userId){

        userTaskService.getUserById(userId);

        List<Task> tasks = taskRepository.findByUserId(userId);
        return tasks.stream()
                .map(TaskMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TaskDTO add(TaskDTO taskDTO){

        User user = userTaskService.getUserById(taskDTO.getUserId());

       Task task = TaskMapper.toEntity(taskDTO, user);
       taskRepository.save(task);
       taskDTO.setId(task.getId());
       return taskDTO;
    }

    public TaskDTO update(TaskDTO taskDTO){

        Long taskId = taskDTO.getId();
        Task task = taskRepository.findById(taskId)
                .orElseThrow(TaskNotFoundException::new);


        if (taskDTO.getTitle() != null && !taskDTO.getTitle().isEmpty()) {
            task.setTitle(taskDTO.getTitle());
        }

        if (taskDTO.getDescription() != null && !taskDTO.getDescription().isEmpty()) {
            task.setDescription(taskDTO.getDescription());
        }

        if(taskDTO.getCompleted() != null){
            task.setCompleted(taskDTO.getCompleted());
        }

        Long userId = taskDTO.getUserId();
        if(userId != null && !userId.equals(task.getUser().getId())){
            User user = userTaskService.getUserById(userId);
            task.setUser(user);
        }

        Task updatedTask = taskRepository.save(task);
        return TaskMapper.toDTO(updatedTask);
    }

    public String deleteById(Long taskId){
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found with id " + taskId));

        taskRepository.delete(task);
        return "Deleted successfully with id " + taskId;
    }



}
