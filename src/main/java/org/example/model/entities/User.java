package org.example.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
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
        }