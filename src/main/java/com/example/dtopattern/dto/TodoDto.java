package com.example.dtopattern.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class TodoDto {
    private int todoId;
    private String title;
    @NotNull(message = "Description should not be null")
    private String description;
    @Min(value=1, message = "Status should be greater than 0")
    private int todoStatus;

    public TodoDto() {
    }

    public TodoDto(int todoId, String title, String description, int todoStatus) {
        this.todoId = todoId;
        this.title = title;
        this.description = description;
        this.todoStatus = todoStatus;
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTodoStatus() {
        return todoStatus;
    }

    public void setTodoStatus(int todoStatus) {
        this.todoStatus = todoStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
