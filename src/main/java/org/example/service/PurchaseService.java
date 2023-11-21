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
    private final PurchaseMapper purchaseMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    PurchaseService(PurchaseRepository purchaseRepository, PurchaseMapper purchaseMapper,
                    UserRepository userRepository, UserMapper userMapper) {
        this.purchaseRepository = purchaseRepository;
        this.purchaseMapper = purchaseMapper;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public PurchaseSearchDTO makePurchase(PurchaseCreateDTO purchaseCreateDTO) {
        //validam userul, daca exista un user cu id-ul = user_id din request
        User user = userRepository.findById(purchaseCreateDTO.getUserId()).orElseThrow(() -> new RuntimeException());

        //construim un purchase entity pe baza purchaseCreateDTO (requestul de la client)
        Purchase purchase = purchaseMapper.mapPurchaseCreateDTOToPurchaseEntity(purchaseCreateDTO);
        purchase.setUser(user);
        //salvam purchase-ul
        Purchase savedPurchase = purchaseRepository.save(purchase);

        //construim un response object (UserSearchDTO) pe care il returnam catre controller
        UserSearchDTO userSearchDTO = userMapper.mapUserEntityToUserSearchDTO(savedPurchase.getUser());
        PurchaseSearchDTO purchaseSearchDTO = purchaseMapper.mapPurchaseEntityToPurchaseSearchDTO(savedPurchase);
        purchaseSearchDTO.setUser(userSearchDTO);
        return purchaseSearchDTO;
    }


}
