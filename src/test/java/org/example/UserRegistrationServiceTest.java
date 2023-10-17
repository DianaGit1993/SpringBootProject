package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserRegistrationServiceTest {

    UserRegistrationService userRegistrationService = new UserRegistrationService();

    @Test
    public void testRegisterUser(){
        User userForTesting = User.builder().id(1).name("Jhon").build();

        String result = userRegistrationService.registerUser(userForTesting);

        Assertions.assertNotNull(result);
    }
    @Test
    public void testRegisterUserThrowsExceptionWhenUserIsNull(){
        User userForTesting = null;

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () ->userRegistrationService.registerUser(userForTesting), "Expected IllegalArgumentException to be thrown:(");

        Assertions.assertEquals("User can not be null.",exception.getMessage());
        System.out.println("Test succeded//");
    }
}
