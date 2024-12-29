package com.example.dtopattern.service.Imp;

import com.example.dtopattern.Mapping.TodoMapping;
import com.example.dtopattern.dto.TodoDto;
import com.example.dtopattern.entity.StatusVal;
import com.example.dtopattern.entity.Todo;
import com.example.dtopattern.exception.ResourceNotFoundException;
import com.example.dtopattern.repository.StatusRepository;
import com.example.dtopattern.repository.TodoRepository;
import com.example.dtopattern.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImplementation implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public TodoDto createTodo(TodoDto todoDto) {
        StatusVal statusVal = statusRepository.findById(todoDto.getTodoStatus()).orElseThrow(()->new ResourceNotFoundException("Status","Id",String.valueOf(todoDto.getTodoStatus())));
        Todo todo = TodoMapping.toJpa(todoDto,statusVal);
        Todo saveTodo = todoRepository.save(todo);
        return TodoMapping.toDto(saveTodo);
    }

    @Override
    public TodoDto getTodoById(int id) {
        Todo todo = todoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Todo","Id",String.valueOf(id)));
        return TodoMapping.toDto(todo);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> todoList = todoRepository.findAll();
        return todoList.stream().map(TodoMapping::toDto).collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodoById(int id, TodoDto todoDto) {
        Todo existingTodo = todoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Todo","Id",String.valueOf(id)));
        existingTodo.setTitle(todoDto.getTitle());
        existingTodo.setDescription(todoDto.getDescription());

        StatusVal statusVal = statusRepository.findById(todoDto.getTodoStatus()).orElseThrow(()->new ResourceNotFoundException("Status","Id",String.valueOf(todoDto.getTodoStatus())));

        existingTodo.setTodoStatus(statusVal);
        Todo updateTodo = todoRepository.save(existingTodo);
        return TodoMapping.toDto(updateTodo);
    }

    @Override
    public void deleteTodo(int id) {
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo", "Id", String.valueOf(id)));
        todoRepository.delete(existingTodo);
    }
}
