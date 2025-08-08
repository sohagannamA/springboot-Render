package com.example.Practices.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Practices.entity.Todo;
import com.example.Practices.services.TodoService;
import com.example.Practices.utility.ResponseEntityBuilder;
import com.example.Practices.utility.ResponseMessage;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private TodoService todoService;

    TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<ResponseMessage<List<Todo>>> getTodo() {
        try {
            if (todoService.hasTodo()) {
                List<Todo> allTodos = todoService.getAllTodo();
                return ResponseEntityBuilder.success(allTodos, "This is your all todos data", 200, LocalDateTime.now());
            } else {
                return ResponseEntityBuilder.notFound("No todo found. Please add your todo", 404, LocalDateTime.now());
            }
        } catch (Exception e) {
            return ResponseEntityBuilder.serverError("Internal server error", 500, LocalDateTime.now());
        }
    }

    @PostMapping
    public ResponseEntity<ResponseMessage<Todo>> addTodo(@RequestBody Todo newTodo) {
        try {
            if(todoService.CheckDuplicate(newTodo.getTitle())){
                return ResponseEntityBuilder.checkDuplicateMessage("This todo already added", 509, LocalDateTime.now());
            }
            Todo addedTodo = todoService.addTodo(newTodo);
            return ResponseEntityBuilder.success(addedTodo, "New todo is successfully added", 200, LocalDateTime.now());

        } catch (Exception e) {
            return ResponseEntityBuilder.serverError("Internal server error", 500, LocalDateTime.now());
        }
    }
}