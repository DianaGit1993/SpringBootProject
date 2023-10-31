package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.CustomResponseDTO;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class UserController {

    List<User> userList = new ArrayList<>();
    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

//    ResponseEntity<CustomResponseDTO> create...
//    new ResponseEntity(cusomerRes, HttpStatus.OK)
    @PostMapping(path = "/user")
    public ResponseEntity<CustomResponseDTO> createNewUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        CustomResponseDTO customResponseDTO = new CustomResponseDTO();

        if (bindingResult.hasErrors()) {
            String message = bindingResult.getFieldErrors().get(0).getDefaultMessage();
            customResponseDTO.setResponseObject(null);
            customResponseDTO.setResponseMessage(message);

        } else {
//        System.out.println(user.getEmail().toString());
            customResponseDTO.setResponseObject(user);
            userList.add(user);
            customResponseDTO.setResponseMessage("User created successfully");
        }
        return new ResponseEntity<>(customResponseDTO, HttpStatus.CREATED);
    }


    @GetMapping("/getUsersByFirstName/{firstName}")
//    public List<User> getUsersByFirstName(@RequestParam String firstName){ -> Query param ?firstName=alex
    public List<User> getUsersByFirstName(@PathVariable String firstName) { // -> Path param ../23 (23 fiind id-ul)
        return userService.findUsersByFirstName(firstName);
    }

}
