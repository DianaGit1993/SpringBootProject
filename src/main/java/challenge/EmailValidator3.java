package challenge;

public class EmailValidator3 {
    public static boolean isValidEmail(String email){
        if (email == null || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}")){
            throw new IllegalArgumentException("Invalid email address");
        }
        return true;
    }

}
