package org.example.controller;

import org.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GreetingsController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/greetings")
    public String greetings(User user){
        //validate user
        //store user in db
        //
        System.out.println("inside the greetings method");
        return "Welcome";
    }

}
