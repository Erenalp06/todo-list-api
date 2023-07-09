package com.erenalpteksen.todolist.dto;

import com.erenalpteksen.todolist.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTaskDTO {

    private Long id;
    private String name;
    private String email;
    private List<TaskDTO> taskList;
}
