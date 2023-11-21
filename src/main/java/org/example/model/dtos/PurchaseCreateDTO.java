package org.example.model.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.entities.User;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PurchaseCreateDTO {

    //validari @NotBlank, @NotNull, @Min..etc
    private String deliveryType;
    private String productName;
    private Long userId;
}
