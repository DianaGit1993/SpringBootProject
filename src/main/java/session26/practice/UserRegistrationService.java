package session26.practice;

public class UserRegistrationService {

    public String registerUser(User user){
        System.out.println("Registering new user "+ user.toString());
        return user.toString();
    }
}
