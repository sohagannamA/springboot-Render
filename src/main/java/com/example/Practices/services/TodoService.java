package com.example.Practices.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Practices.entity.Todo;
@Service
public interface TodoService {
    List<Todo> getAllTodo();
    boolean hasTodo();
    boolean CheckDuplicate(String title);
    Todo addTodo(Todo newTodo);
}
