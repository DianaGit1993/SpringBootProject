package org.example.controller;
import org.example.model.dtos.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingsController
{
    @GetMapping("/home")
    public String home()
    {
        return "home";
    }
        @GetMapping("/greetings")
        public String greetings(UserDTO user)
        {
            //validate name
            //store user in db
            System.out.println("inside the greetings method");
            return "Welcome";
        }




}
