package com.practice.todoapp.ServiceImpl;

import com.practice.todoapp.Repository.TodoRepository;
import com.practice.todoapp.Service.TodoService;
import com.practice.todoapp.model.TodoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<TodoModel> getAllTodos() {
        return todoRepository.findAll();
    }
    @Override
    public TodoModel addTodo(TodoModel todo) {
        return todoRepository.save(todo);
    }
    @Override
    public TodoModel getTodoById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteTodo(TodoModel todo) {
        todoRepository.delete(todo);
    }
}
