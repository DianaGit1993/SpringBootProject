package org.example;

import org.example.testexamples.EmailService;
import org.example.testexamples.User;
import org.example.testexamples.UserRegistrationService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class UserRegistrationsServiceTest {


    @Mock
    EmailService emailService;


    @InjectMocks
    UserRegistrationService userRegistrationService = new UserRegistrationService();

    @Test
    public void testRegisterUser(){
        User userForTesting = User.builder().id(2).name("john").build();
        String result = userRegistrationService.registerUser(userForTesting);
        Assertions.assertNotNull(result);




    }

    public void testRegisterUserThrowsExceptionWhenUserIsNull(){
        User userForTesting = null;

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> userRegistrationService.registerUser(userForTesting),
                "Expected illegalargumetexception to be thrown ");

        Assertions.assertTrue(exception.getMessage().contains("User can not be null."));
    }
}
