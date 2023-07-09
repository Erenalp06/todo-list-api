package com.erenalpteksen.todolist.service;

import com.erenalpteksen.todolist.dto.TaskDTO;
import com.erenalpteksen.todolist.dto.UserDTO;
import com.erenalpteksen.todolist.dto.UserTaskDTO;
import com.erenalpteksen.todolist.entity.User;
import com.erenalpteksen.todolist.exception.custom.UserNotFoundException;
import com.erenalpteksen.todolist.repository.UserRepository;
import com.erenalpteksen.todolist.util.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserTaskService userTaskService;

    public UserTaskDTO findAllByUserId(Long userId){
        User user = userTaskService.getUserById(userId);

        List<TaskDTO> taskList = userTaskService.getTasksByUserId(userId);
        return UserTaskDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .taskList(taskList)
                .build();
    }

    public UserDTO add(UserDTO userDTO){
        User user = UserMapper.toEntity(userDTO);
        userRepository.save(user);
        userDTO.setId(user.getId());
        return userDTO;
    }

    public UserDTO update(UserDTO userDTO){
        Long userId = userDTO.getId();
        User user = userTaskService.getUserById(userId);

        if(userDTO.getName() != null && !userDTO.getName().isEmpty()){
            user.setName(userDTO.getName());
        }

        if(userDTO.getEmail() != null && !userDTO.getEmail().isEmpty()){
            user.setEmail(userDTO.getEmail());
        }

        User updatedUser = userRepository.save(user);
        return UserMapper.toDTO(updatedUser);
    }

    public String deleteById(Long userId){
        userTaskService.getUserById(userId);
        return "User deleted successfully";
    }

}
