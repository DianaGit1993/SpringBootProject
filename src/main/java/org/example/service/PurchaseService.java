package org.example.service;

import org.example.model.dtos.PurchaseCreateDTO;
import org.example.model.dtos.PurchaseDTO;
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
    private final UserRepository userRepository;
    private final PurchaseMapper purchaseMapper;

    @Autowired
    PurchaseService(PurchaseRepository purchaseRepository, PurchaseMapper purchaseMapper, UserRepository userRepository) {
        this.purchaseRepository= purchaseRepository;
        this.userRepository= userRepository;
        this.purchaseMapper= purchaseMapper;
    }

    public PurchaseDTO makePurchase(PurchaseCreateDTO purchaseDTO) {
        User user = userRepository.findById(purchaseDTO.getUserId()).orElseThrow(()->new RuntimeException("User not found by id."));
       Purchase purchase = new Purchase();
       purchase.setUser(user);
       purchase.setDeliveryType(purchaseDTO.getDeliveryType());

        Purchase createdPurchase = purchaseRepository.save(purchase);
       return purchaseMapper.mapPurchaseEntityToPurchaseDTO(createdPurchase);
    }

    public List<PurchaseDTO> findAllPurchases(){
        List<Purchase> userEntities = purchaseRepository.findAll();
        return userEntities.stream().map(purchaseMapper::mapPurchaseEntityToPurchaseDTO).collect(Collectors.toList());
    }

}
