package org.example.controller;


import org.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GreetingsController {

    @GetMapping("/greetings")
    public String greetings(User user){
        System.out.println("Inside the greetings method");
        return "Welcome";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
