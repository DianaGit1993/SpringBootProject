package org.example.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import org.example.model.CustumResponseDTO;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path="/api/v1")//sa mapeze codul nostru,el functioneaza la nivel de clasa
public class UserController
{

    private final UserService userService;
    @Autowired
    UserController(UserService userService)
    {
        this.userService=userService;
    }

    @PostMapping(path="/user")//SA CREEAM RESURSE NOI
    public ResponseEntity<CustumResponseDTO> createNewUser(@RequestBody @Valid User user , BindingResult bindingResult)//ii spune unde sa se uite cu requestBody
    {
        //request body-ii spune sa se uite in corpul din json
        //valid=trebuie pus ca sa fie luate @notblack,etc
        //binding result -contine informatii despre ce erori s au aruncat
        CustumResponseDTO custumResponseDTO=new CustumResponseDTO();
        if(bindingResult.hasErrors())
        {
          String errorMessage= bindingResult.getFieldError().getDefaultMessage();
          custumResponseDTO.setResponseObject(null);
          custumResponseDTO.setResponseMessage(errorMessage);
          return new ResponseEntity<>(custumResponseDTO,HttpStatus.BAD_REQUEST);
        }

            custumResponseDTO.setResponseObject(user);
            custumResponseDTO.setResponseMessage("User ul a fost creat");
        //System.out.println(user.getEmail().toString());
        return new ResponseEntity<>(custumResponseDTO, HttpStatus.CREATED);
    }



    @GetMapping("/getUsersByFirstName")
    public List<User> getUsersByFirstName(@RequestParam(required = false) String firstName)
    {

        return userService.fiindUsersByFirstName(firstName);
    }


}
