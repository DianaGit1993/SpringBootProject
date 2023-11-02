package org.example;

import org.example.testexamples.EmailService;
import org.example.testexamples.User;
import org.example.testexamples.UserRegistrationService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class UserRegistrationServiceTest {

    @Mock
    EmailService emailService;

    @InjectMocks
    UserRegistrationService userRegistrationService = new UserRegistrationService(emailService);

    @BeforeEach // @Before for other JUnit versions
    public void beforeEveryTest(){
        System.out.println("Starting new test");
    }

    @BeforeEach  // @BeforeClass for other JUnit versions
    public void setUp(){
        System.out.println("Running test for UserRegistrationService");
    }

    @AfterEach
    public void cleanAfterTest(){
        //clean after every test
        System.out.println("Finished one test");
    }

    @AfterAll
    public static void cleanAfterAllTests(){
        // clean after all test
        System.out.println("Finished all tests");
    }

    @Test
    public void testRegisterUser(){
        User userForTesting = User.builder().id(1).name("Jhon").build();

        String result = userRegistrationService.registerUser(userForTesting);

        Assertions.assertNotNull(result);
    }

    @Test
    public void testRegisterUserThrowsExceptionWhenUserIsNull(){
        User userForTesting = null;

        IllegalArgumentException exception = Assertions.
                assertThrows(IllegalArgumentException.class,
                        () -> userRegistrationService.registerUser(userForTesting),
                        "Expected IllegalArgumentException to be thrown :( ");

        //Assertions.assertTrue(exception.getMessage().contains("User can not be null"));
        Assertions.assertEquals("User can not be null", exception.getMessage());
    }

    @Test
    public void testRegisterUserWithEmailConfirmation(){
        //Given /Arrange
        User userForTesting = User.builder().id(1).name("Jhon").build();
        when(emailService.sendConfirmationEmail()).thenReturn("Email was sent");
        //Act
        String result = userRegistrationService.registerUser(userForTesting);

    }
}
