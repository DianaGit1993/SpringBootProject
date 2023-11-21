package org.example.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PurchaseSearchDTO {

    private Long id;
    private String deliveryType;
    private String productName;
    private UserSearchDTO user;
}
