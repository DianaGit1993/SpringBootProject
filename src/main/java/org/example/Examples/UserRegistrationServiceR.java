package org.example.Examples;
import java.util.Objects;
public class UserRegistrationServiceR
{


    public class UserRegistrationService {

        private EmailServiceR emailService;

        UserRegistrationService(EmailServiceR emailService){
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
}
