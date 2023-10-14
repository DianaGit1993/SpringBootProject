package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class UserRegistrationsServiceTest {

    UserRegistrationService userRegistrationService = new UserRegistrationService();

    @Test
    public void testRegisterUser(){
        User userForTesting = User.builder().id(2).name("john").build();
        String result = userRegistrationService.registerUser(userForTesting);
        Assertions.assertNotNull(result);


    }
}
