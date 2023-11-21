package org.example.service;

import org.example.model.dtos.PurchaseCreateDTO;
import org.example.model.dtos.PurchaseSearchDTO;
import org.example.model.dtos.UserCreateDTO;
import org.example.model.dtos.UserSearchDTO;
import org.example.model.entities.Purchase;
import org.example.model.entities.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapper {

    UserRepository userRepository;
    UserMapper userMapper;

    public PurchaseMapper(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Purchase mapPurchaseCreateDTOtoPurchaseEntity(PurchaseCreateDTO purchaseCreateDTO) {
        User user = userRepository.findById(purchaseCreateDTO.getUserId()).orElseThrow(() -> new RuntimeException());
        Purchase purchase = new Purchase();
        purchase.setDeliveryType(purchaseCreateDTO.getDeliveryType());
        purchase.setProductName(purchaseCreateDTO.getProductName());
        purchase.setUser(user);
        return purchase;
    }

    public PurchaseSearchDTO mapPurchaseEntityToPurchaseSearchDTO(Purchase purchase) {
        return PurchaseSearchDTO.builder()
                .productName(purchase.getProductName())
                .deliveryType(purchase.getDeliveryType())
                .user(userMapper.mapUserEntityToUserSearchDTO(purchase.getUser()))
                .build();
    }

}
