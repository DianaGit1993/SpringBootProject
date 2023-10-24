package org.example.testexamples;


import java.util.Objects;

public class UserRegistrationService {

    private EmailService emailService;

    UserRegistrationService(EmailService emailService){
        this.emailService = emailService;
    }

    public String registerUser(User user){
        if(Objects.isNull(user)){
            throw new IllegalArgumentException("User can not be null.");
        }
        System.out.println("Registering new user "+ user);
        String message = emailService.sendConfirmationEmail(user.getName());
        System.out.println(message);

        return user.toString();
    }
}
