package org.example;

import org.junit.Test;

public class UserRegistrationService {


    public String registerUser(User user){
        System.out.println("Registering new user " + user.toString());
        return user.toString();

    }
}
