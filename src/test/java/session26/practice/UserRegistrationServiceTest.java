package session26.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserRegistrationServiceTest {

    UserRegistrationService userRegistrationService = new UserRegistrationService();

    @Test
    public void testRegisterUser(){
        Users userForTesting = Users.builder().id(1).name("John").build();

        String result = userRegistrationService.registerUser(userForTesting);

        Assertions.assertNotNull(result);
    }
}
