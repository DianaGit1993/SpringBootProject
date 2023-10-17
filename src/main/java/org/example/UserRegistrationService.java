package org.example;

import java.util.Objects;

public class UserRegistrationService {

    public String registerUser(User user){

        if(Objects.isNull(user)){
            throw new IllegalArgumentException("User can not be null.");
        }
        System.out.println("Registering new user "+ user.toString());
        return user.toString();
    }
}
