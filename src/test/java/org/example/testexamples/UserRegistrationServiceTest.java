package org.example.testexamples;

import org.example.testexamples.EmailService;
import org.example.testexamples.User;
import org.example.testexamples.UserRegistrationService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserRegistrationServiceTest {
    @Mock
    EmailService emailService;
    @InjectMocks
    UserRegistrationService userRegistrationService = new UserRegistrationService(emailService);
    @BeforeEach
    public void beforeEachTest() {
        System.out.println("Starting new test");
    }
    @BeforeAll
    public static void setUp() {
        System.out.println("Running test for UserRegistrationService");
    }
    @AfterEach
    public void cleanAfterTest() {
        //cleanup after every test
        System.out.println("Finished one test.");
    }
    @AfterAll
    public static void cleanAfterAllTests() {
        //cleanup after all tests
        System.out.println("Finished all test.");
    }
    @Test
    //@Timeout(1)
    public void testRegisterUser(){
        //Arrange
        User userForTesting = User.builder().id(1).name("Jhon").build();
        //Act
        String result = userRegistrationService.registerUser(userForTesting);
        //Assert4
        Assertions.assertNotNull(result);
    }

    @Test
    public void testRegisterUserThrowsExceptionWhenUserIsNull(){
        User userForTesting = null;

        IllegalArgumentException exception = Assertions.
            assertThrows(IllegalArgumentException.class,
                () -> userRegistrationService.registerUser(userForTesting),
                "Expected IllegalArgumentException to be thrown :(");

        Assertions.assertTrue(exception.getMessage().contains("user can not be null."));
    }

    @Test
    public void testRegisterUserWithEmailConfirmation(){
        // GIVEN / Arrange
        User userForTesting = User.builder().id(1).name("Jhon").build();
        when(emailService.sendConfirmationEmail(userForTesting.getName())).thenReturn("Email was send.");

        userRegistrationService.registerUser(userForTesting);

        Mockito.verify(emailService, Mockito.times(1)).sendConfirmationEmail(userForTesting.getName());

    }
}
