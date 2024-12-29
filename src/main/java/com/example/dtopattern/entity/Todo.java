package com.example.dtopattern.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int todoId;
    private String title;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id")
    @JsonManagedReference
    private StatusVal todoStatus;


    public Todo() {
    }

    public Todo(int todoId, String title, String description, StatusVal todoStatus) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusVal getTodoStatus() {
        return todoStatus;
    }

    public void setTodoStatus(StatusVal todoStatus) {
        this.todoStatus = todoStatus;
    }
}
