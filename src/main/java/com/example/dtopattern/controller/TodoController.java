package com.example.dtopattern.controller;

import com.example.dtopattern.dto.TodoDto;
import com.example.dtopattern.service.TodoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/Todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("/createTodo")
    public ResponseEntity<TodoDto> createTodo (@Valid @RequestBody TodoDto todoDto){
        System.out.println("Inside create todo");
        TodoDto todoDto1 = todoService.createTodo(todoDto);
        return new ResponseEntity<>(todoDto1, HttpStatus.CREATED);
    }

    @GetMapping("/getAllTodos")
    public ResponseEntity<List<TodoDto>> getAllTodos(){
        List<TodoDto> todoDtoList = todoService.getAllTodos();
        return new ResponseEntity<>(todoDtoList,HttpStatus.OK);
    }

    @GetMapping("/getTodoById/{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable int id){
        TodoDto todoDto = todoService.getTodoById(id);
        return new ResponseEntity<>(todoDto,HttpStatus.OK);
    }

    @PutMapping("updateTodoById/{id}")
    public ResponseEntity<TodoDto> updateTodoById(@RequestBody TodoDto todoDto, @PathVariable int id){
        TodoDto todoDto1 = todoService.updateTodoById(id,todoDto);
        return new ResponseEntity<>(todoDto1,HttpStatus.OK);
    }

    @DeleteMapping("deleteTodoById/{id}")
    public ResponseEntity<String> deleteToById(@PathVariable int id){
        todoService.deleteTodo(id);
        return ResponseEntity.ok("Todo deleted successfully");
    }
}
