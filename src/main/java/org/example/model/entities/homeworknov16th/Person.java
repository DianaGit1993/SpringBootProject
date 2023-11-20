package org.example.model.entities.homeworknov16th;

import jakarta.persistence.*;

@Entity
@Table(name = "persons")
public class Person {
    // OneToOne relationship with Address class
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

}
