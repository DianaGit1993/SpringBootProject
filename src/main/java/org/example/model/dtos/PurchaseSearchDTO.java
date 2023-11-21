package org.example.model.dtos;

import lombok.*;
import org.example.model.entities.User;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class PurchaseSearchDTO {

    private String deliveryType;
    private String productName;
    private UserSearchDTO user;


}
