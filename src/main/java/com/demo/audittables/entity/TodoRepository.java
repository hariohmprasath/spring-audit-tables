package com.demo.audittables.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface TodoRepository extends RevisionRepository<Todo, Integer, Integer>
        , JpaRepository<Todo, Integer> {
}
