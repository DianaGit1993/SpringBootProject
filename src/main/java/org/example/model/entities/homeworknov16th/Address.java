package org.example.model.entities.homeworknov16th;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
     // OneToOne relationship with Person class
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zip;

    @OneToOne(mappedBy = "address")
    private Person person;
}
