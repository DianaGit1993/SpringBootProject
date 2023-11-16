package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.CustomResponseDTO;
import org.example.model.dtos.PurchaseCreateDTO;
import org.example.model.dtos.PurchaseDTO;
import org.example.model.dtos.UserCreateDTO;
import org.example.model.dtos.UserSearchDTO;
import org.example.service.PurchaseService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/api/v1")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @Autowired
    PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping(path = "/purchase")
    public ResponseEntity<PurchaseDTO> makePurchase(@RequestBody @Valid PurchaseCreateDTO purchaseDTO) {
//        CustomResponseDTO customResponseDTO = new CustomResponseDTO();

//        if (bindingResult.hasErrors()) {
//            String errorMessage = bindingResult.getFieldError().getDefaultMessage();
//            customResponseDTO.setResponseObject(null);
//            customResponseDTO.setResponseMessage(errorMessage);
//            return new ResponseEntity<>(customResponseDTO, HttpStatus.BAD_REQUEST);
//        }

//        customResponseDTO.setResponseObject(userCreateDTO);
//        userCreateDTOList.add(userCreateDTO);
//        customResponseDTO.setResponseMessage("User created successfully");
        return new ResponseEntity<>(purchaseService.makePurchase(purchaseDTO), HttpStatus.CREATED);
    }

//    @PutMapping(path = "/user")
//    public ResponseEntity<CustomResponseDTO> updateUser(UserUpdateDTO){
//        //...\
//        return null;
//    }

    @GetMapping(path = "/purchase")
    public ResponseEntity<CustomResponseDTO> getAllPurchases(){
        List<PurchaseDTO> userSearchDTOS = purchaseService.findAllPurchases();
        CustomResponseDTO customResponseDTO = new CustomResponseDTO();
        if(Objects.isNull(userSearchDTOS) || userSearchDTOS.isEmpty()){
            customResponseDTO.setResponseMessage("No user has been found");
            return new ResponseEntity<>(customResponseDTO, HttpStatus.NOT_FOUND);
        }
        customResponseDTO.setResponseObject(userSearchDTOS);
        customResponseDTO.setResponseMessage("Users found successfully!");
        return new ResponseEntity<>(customResponseDTO, HttpStatus.OK);
    }



}
