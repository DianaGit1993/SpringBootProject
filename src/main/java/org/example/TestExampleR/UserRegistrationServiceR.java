package org.example.TestExampleR;

import java.util.Objects;

public class UserRegistrationServiceR {

    private EmailServiceR emailService;

    public UserRegistrationServiceR(EmailServiceR emailService){
        this.emailService = emailService;
    }

    public String registerUser(UserR user){
        if(Objects.isNull(user)){
            throw new IllegalArgumentException("User can not be null.");
        }
        System.out.println("Registering new user "+ user);
        String message = emailService.sendConfirmationEmail(user.getName());
        System.out.println(message);

        return user.toString();
    }
}