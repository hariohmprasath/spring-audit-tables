package com.demo.audittables.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Data
public class Todo {
    @Id
    @GeneratedValue
    private int id;
    private String description;
    private boolean completed;

    public Todo() {
    }

    public Todo(String description) {
        this.description = description;
    }
}
