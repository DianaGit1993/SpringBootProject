package org.example.service;

import org.example.model.dtos.PurchaseCreateDTO;
import org.example.model.dtos.PurchaseSearchDTO;
import org.example.model.dtos.UserCreateDTO;
import org.example.model.dtos.UserSearchDTO;
import org.example.model.entities.Purchase;
import org.example.model.entities.User;
import org.example.repository.PurchaseRepository;
import org.example.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper; // custom mapper

    @Autowired
    PurchaseService(PurchaseRepository purchaseRepository, PurchaseMapper purchaseMapper) {
        this.purchaseRepository = purchaseRepository;
        this.purchaseMapper = purchaseMapper;
    }

    public PurchaseSearchDTO makePurchase(PurchaseCreateDTO purchaseCreateDTO){
        Purchase purchase = purchaseRepository.save(purchaseMapper.mapPurchaseCreateDTOtoPurchaseEntity(purchaseCreateDTO));
        PurchaseSearchDTO purchaseSearchDTO = purchaseMapper.mapPurchaseEntityToPurchaseSearchDTO(purchase);
        return purchaseSearchDTO;
    }

}
