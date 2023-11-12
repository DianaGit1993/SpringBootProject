package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);

//        System.out.println("Hello world!");
//        UserDTO user = new UserDTO(2,"Jhon");
//        user.getId();
//        user.setId(2);
//
//        UserDTO user2 = UserDTO.builder().id(2).name("Jhon").build();
    }
}