package org.example.model.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.entities.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {


    private long id;
    private String streetName;
    private int floorNo;
    private int streetNo;
    private String city;
    private UserSearchDTO user;
}
