package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.CustomResponseDTO;
import org.example.model.dtos.PurchaseCreateDTO;
import org.example.model.dtos.PurchaseSearchDTO;
import org.example.model.dtos.UserCreateDTO;
import org.example.model.dtos.UserSearchDTO;
import org.example.service.PurchaseService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
public class PurchaseController {

    private final PurchaseService purchaseService;
    @Autowired
    PurchaseController(PurchaseService purchaseService){
        this.purchaseService = purchaseService;
    }

    @PostMapping(path = "/purchase")
    public ResponseEntity<CustomResponseDTO> makePurchase(@RequestBody @Valid PurchaseCreateDTO purchaseCreateDTO, BindingResult bindingResult){
        CustomResponseDTO customResponseDTO = new CustomResponseDTO();

        if(bindingResult.hasErrors()){
            String errorMessage = bindingResult.getFieldError().getDefaultMessage();
            customResponseDTO.setResponseObject(null);
            customResponseDTO.setResponseMessage(errorMessage);
            return new ResponseEntity<>(customResponseDTO, HttpStatus.BAD_REQUEST);
        }
        PurchaseSearchDTO purchaseSearchDTO = purchaseService.makePurchase(purchaseCreateDTO);

        customResponseDTO.setResponseObject(purchaseSearchDTO);
        customResponseDTO.setResponseMessage("Purchase made successfully");
        return new ResponseEntity<>(customResponseDTO, HttpStatus.CREATED);
    }
}
