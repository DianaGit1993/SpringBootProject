package org.example.testexamples;

import org.example.testexamples.EmailService;
import org.example.testexamples.User;

import java.util.Objects;

public class UserRegistrationService {


    private EmailService emailService;

    public UserRegistrationService(){
        this.emailService = emailService;
    }


    public String registerUser(User user){
        if (Objects.isNull(user)){
            throw new IllegalArgumentException("User can not be null");
        }

        System.out.println("registering new user " + user);
        return user.toString();

    }
}
