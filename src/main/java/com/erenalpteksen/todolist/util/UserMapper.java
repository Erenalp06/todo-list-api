package com.erenalpteksen.todolist.util;

import com.erenalpteksen.todolist.dto.UserDTO;
import com.erenalpteksen.todolist.entity.User;

public class UserMapper {

    public static UserDTO toDTO(User user){
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public static User toEntity(UserDTO userDTO){
        return User.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .build();
    }
}
