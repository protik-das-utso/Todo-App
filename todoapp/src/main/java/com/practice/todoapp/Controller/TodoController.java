package com.practice.todoapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {

    @GetMapping({"", "/", "/home", "/index"})
    public String showHomePage(){
        return "index";
    }
}
