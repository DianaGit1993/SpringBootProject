package org.example.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserSearchDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private int age;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private List<PurchaseDTO> purchaseDTOs;
    private List<AddressDTO> address;
}
