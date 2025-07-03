package com.practice.todoapp.Service;

import com.practice.todoapp.Repository.TodoRepository;
import com.practice.todoapp.model.TodoModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {
    List<TodoModel> getAllTodos();
    TodoModel addTodo(TodoModel todo);
    TodoModel getTodoById(Long id);
    void deleteTodo(TodoModel todo);
}
