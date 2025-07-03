package com.practice.todoapp.Controller;

import com.practice.todoapp.Service.TodoService;
import com.practice.todoapp.model.TodoModel;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping({"", "/", "/home", "/index"})
    public String showHomePage(Model model){
        model.addAttribute("todos", todoService.getAllTodos());
        return "index";
    }
    @PostMapping( "/add")
    public String addTodo(@RequestParam String title) {
        TodoModel newTodo = TodoModel.builder()
                .title(title)
                .completed(false)
                .build();
        todoService.addTodo(newTodo);
        return "redirect:/";
    }
    @GetMapping("update/{id}")
    public String updateTodo(@PathVariable long id){
        TodoModel existingTodo = todoService.getTodoById(id);

        existingTodo.setCompleted(!existingTodo.isCompleted());
        todoService.addTodo(existingTodo);

        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteTod(@PathVariable long id){
        TodoModel todo = todoService.getTodoById(id);
        if (todo != null) {
            todoService.deleteTodo(todo);
        }
        return "redirect:/";
    }
}
