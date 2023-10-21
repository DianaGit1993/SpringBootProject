package org.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingsController {
    @GetMapping("/greetings")
    public String greetings (){
        System.out.println("inside the greetings method");
        return "Welcome ";
    }

    @GetMapping("/greetingsAndrei")
    public String greetingsAndrei(){
        return "Salut Andrei" ;
    }
}
