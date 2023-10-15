package session26.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session26.practice.User;
import session26.practice.UserRegistrationService;

public class UserRegistrationServiceTest {

    UserRegistrationService userRegistrationService = new UserRegistrationService();

    @Test
    public void testRegisterUser(){
        User userForTesting = User.builder().id(1).name("John").build();

        String result = userRegistrationService.registerUser(userForTesting);

        Assertions.assertNotNull(result);
    }
}
