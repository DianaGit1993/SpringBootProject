package org.example.service;

import org.example.model.dtos.PurchaseCreateDTO;
import org.example.model.dtos.PurchaseSearchDTO;
import org.example.model.entities.Purchase;
import org.springframework.stereotype.Service;

@Service
public class PurchaseMapper {

    public Purchase mapPurchaseCreateDTOToPurchaseEntity(PurchaseCreateDTO purchaseCreateDTO){
        Purchase purchase = new Purchase();
        purchase.setDeliveryType(purchaseCreateDTO.getDeliveryType());
        purchase.setProductName(purchaseCreateDTO.getProductName());
        return purchase;
    }

    public PurchaseSearchDTO mapPurchaseEntityToPurchaseSearchDTO(Purchase purchase){
        PurchaseSearchDTO purchaseSearchDTO = new PurchaseSearchDTO();
        purchaseSearchDTO.setDeliveryType(purchase.getDeliveryType());
        purchaseSearchDTO.setProductName(purchase.getProductName());
        return purchaseSearchDTO;
    }
}

