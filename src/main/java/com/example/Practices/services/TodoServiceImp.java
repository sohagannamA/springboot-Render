package com.example.Practices.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Practices.entity.Todo;
import com.example.Practices.repository.TodoRepository;

@Service
public class TodoServiceImp implements TodoService {

    private final TodoRepository todoRepository;

    TodoServiceImp(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    public Todo addTodo(Todo newTodo) {
        return todoRepository.save(newTodo);
    }

    public boolean hasTodo() {
        return todoRepository.count() > 0 ? true : false;
    }

    public boolean CheckDuplicate(String title){
        return todoRepository.existsByTitle(title);
    }
}
