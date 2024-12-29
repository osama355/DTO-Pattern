package com.example.dtopattern.Mapping;

import com.example.dtopattern.dto.TodoDto;
import com.example.dtopattern.entity.StatusVal;
import com.example.dtopattern.entity.Todo;

public class TodoMapping {
    public static TodoDto toDto(Todo todo){
        return new TodoDto(
                todo.getTodoId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getTodoStatus().getStatusId()
        );
    }

    public static Todo toJpa(TodoDto todoDto, StatusVal statusVal){
        return new Todo(
                todoDto.getTodoId(),
                todoDto.getTitle(),
                todoDto.getDescription(),
                statusVal
        );
    }
}
