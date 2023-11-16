package org.example.service;

import org.example.model.dtos.PurchaseDTO;
import org.example.model.dtos.UserCreateDTO;
import org.example.model.dtos.UserSearchDTO;
import org.example.model.entities.Purchase;
import org.example.model.entities.User;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapper {


    public Purchase mapPurchaseDTOtoPurchaseEntity(PurchaseDTO purchaseDTO){
        User user= new User();
        if (purchaseDTO.getUser()!=null){
            user = mapUserSearchDTOtoUserEntity(purchaseDTO.getUser());
        }
        Purchase purchase= new Purchase();
        purchase.setId(purchaseDTO.getId());
        purchase.setDeliveryType(purchaseDTO.getDeliveryType());
        purchase.setUser(user);
        return purchase;
    }
    public User mapUserSearchDTOtoUserEntity(UserSearchDTO userCreateDTO) {
        User user = new User();
        user.setUsername(userCreateDTO.getUsername());
        user.setPassword(userCreateDTO.getPassword());
        user.setAge(userCreateDTO.getAge());
        user.setEmail(userCreateDTO.getEmail());
        user.setFirstName(userCreateDTO.getFirstName());
        user.setLastName(userCreateDTO.getLastName());
        return user;
    }
    public PurchaseDTO mapPurchaseEntityToPurchaseDTO(Purchase purchaseEntity){
        UserSearchDTO userSearchDTO = new UserSearchDTO();
        PurchaseDTO purchase= new PurchaseDTO();
        if (purchaseEntity.getUser()!=null){
            userSearchDTO.setId(purchaseEntity.getUser().getId());
            userSearchDTO.setFirstName(purchaseEntity.getUser().getFirstName());
            userSearchDTO.setLastName(purchaseEntity.getUser().getLastName());
            userSearchDTO.setAge(purchaseEntity.getUser().getAge());
            userSearchDTO.setUsername(purchaseEntity.getUser().getUsername());
        }
        purchase.setId(purchaseEntity.getId());
        purchase.setDeliveryType(purchaseEntity.getDeliveryType());
        purchase.setUser(userSearchDTO);
        return purchase;
    }

}
