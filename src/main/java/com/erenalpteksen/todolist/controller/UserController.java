package com.erenalpteksen.todolist.controller;

import com.erenalpteksen.todolist.dto.UserDTO;
import com.erenalpteksen.todolist.dto.UserTaskDTO;
import com.erenalpteksen.todolist.repository.UserRepository;
import com.erenalpteksen.todolist.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserTaskDTO> findByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(userService.findAllByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.add(userDTO));
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.update(userDTO));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.deleteById(userId));
    }


}
