package org.example.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity(name = "user")
@Table(name="users")
//public class UserEntity {
//    private String firstName;
//    private String lastName;
//    private String userName;
//    private String email;
//    private int age;
//    private String password;
//}

public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private int age;
    private String password;

    // de vazut fiecare user ce purchase-uri are
    @OneToMany(mappedBy = "user")
    private List<Purchase> purchases;


        }