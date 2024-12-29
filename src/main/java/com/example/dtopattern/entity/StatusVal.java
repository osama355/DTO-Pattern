package com.example.dtopattern.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class StatusVal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusId;
    private String status;
    @OneToMany(mappedBy = "todoStatus", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Todo> todos;

    public StatusVal() {
    }

    public StatusVal(int statusId, List<Todo> todos, String status) {
        this.statusId = statusId;
        this.todos = todos;
        this.status = status;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
