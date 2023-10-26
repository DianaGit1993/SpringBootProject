package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/getUsersByFirstName/{firstName}")
//    public List<User> getUsersByFirsdwwqdwtName(@RequestParam String firstName){ -> Query param ?firstName=alex
    public List<User> getUsersByFirsdwwqdwtName(@PathVariable String firstName){ // -> Path param ../23 (23 fiind id-ul)
        return userService.findUsersByFirstName(firstName);
    }

}
