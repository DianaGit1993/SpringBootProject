package org.example.controller;

import org.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class GreeetingsController {

    // User-ul merge pe home, e returnata pagina in care i se cere sa completeze firstName si lastName
    // iar cand apasa "Submit", e redirectionat in home.html la url-ul din form action, adica pe greetings (pe controllerul greetings)
    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/greetings")
    public String geetings(User user ){
        // validate user
        // store user in db
        //
        System.out.println("inside the greetings method");
        return "Welcome ";
    }





//    @GetMapping("/greetingsAndrei")
//    public String test123(){
//        return "Salut Andrei";
//    }



}
