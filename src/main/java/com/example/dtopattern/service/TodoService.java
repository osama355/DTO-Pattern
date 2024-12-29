package com.example.dtopattern.service;

import com.example.dtopattern.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto createTodo(TodoDto todoDto);

    TodoDto getTodoById(int id);

    List<TodoDto> getAllTodos();

    TodoDto updateTodoById(int id, TodoDto todoDto);

    void deleteTodo(int id);
}
