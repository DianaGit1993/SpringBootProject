package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/getUsersByFirstName")
    public List<User> getUsersByFirstName(@RequestParam String firstName) {
        return userService.findUsersByFirstName(firstName);
    }
}
