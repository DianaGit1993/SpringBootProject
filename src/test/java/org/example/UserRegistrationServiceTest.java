package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.api.parallel.Execution;


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

       IllegalArgumentException exception =Assertions.
               assertThrows(IllegalArgumentException.class,
                       ()-> userRegistrationService.registerUser(userForTesting),
                       "Expected IllegalArgumentException to be throw :(");

        Assertions.assertTrue(exception.getMessage().contains("User can not be null."));
        System.out.println("Test Succeded//");
    }
}
