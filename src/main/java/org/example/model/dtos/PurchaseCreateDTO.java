package org.example.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.entities.User;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PurchaseCreateDTO {

    private long id;
    private String deliveryType;
    private long userId;
}
