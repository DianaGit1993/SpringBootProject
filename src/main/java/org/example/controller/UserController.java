package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.CustomResponseDTO;
import org.example.model.dtos.UserDTO;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class UserController {

    List<UserDTO> userDTOList = new ArrayList<>();

    private final UserService userService;
    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    //ResponseEntity<CustomResponseDTO> create

    @PostMapping(path = "/user")
//    @RequestMapping(path = "/userDTO", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> createNewUser(@RequestBody @Valid UserDTO userDTO, BindingResult bindingResult) {

//        CustomResponseDTO customResponseDTO = new CustomResponseDTO();

//        if (bindingResult.hasErrors()) {
//             String message = bindingResult.getFieldErrors().get(0).getDefaultMessage();
//             customResponseDTO.setResponseObject(null);
//             customResponseDTO.setResponseMessage(message);
//             return new ResponseEntity<>(customResponseDTO, HttpStatus.BAD_REQUEST);
//        }

//        userService.createUser(userDTO);
//        customResponseDTO.setResponseObject(userDTO);
//        userDTOList.add(userDTO);
//        customResponseDTO.setResponseMessage("UserDTO created successfully");

        //System.out.println(userDTO.getEmail().toString());

        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
    }



//    @GetMapping("/getUsersByFirstName")
//    public List<UserDTO> getUsersByFirstName(@RequestParam(required = false) String firstName) {
//        return userService.findUsersByFirstName(firstName);
//    }
//    @GetMapping("/getUsersByFirstName/{firstName}")
//    public List<UserDTO> getUsersByFirstName(@PathVariable String firstName) {
//        return userService.findUsersByFirstName(firstName);
//    }
}
