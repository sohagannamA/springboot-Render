package com.example.Practices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Practices.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    boolean existsByTitle(String title);
};
