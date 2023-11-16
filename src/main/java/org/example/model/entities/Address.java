package org.example.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "address")
@Entity(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String streetName;
    private int floorNo;
    private int streetNo;
    private String city;

    @ManyToMany(mappedBy = "addresses", fetch = FetchType.LAZY)
    private List<User> users;
}
