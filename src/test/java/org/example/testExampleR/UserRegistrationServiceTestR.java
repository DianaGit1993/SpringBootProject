package org.example.testExampleR;

import org.example.TestExampleR.EmailServiceR;
import org.example.TestExampleR.UserR;
import org.example.TestExampleR.UserRegistrationServiceR;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserRegistrationServiceTest {

    @Mock
    EmailServiceR emailService;

    @InjectMocks
    UserRegistrationServiceR userRegistrationService = new UserRegistrationServiceR(emailService);

    @BeforeEach //@Before for other JUnit versions
    public void beforeEveryTest(){
        System.out.println("Starting new test");
    }

    @BeforeAll // @BeforeClass for other JUnit versions
    public static void setUp(){
        System.out.println("Running tests for UserRegistrationService ...");
    }

    @AfterEach
    public void cleanAfterTest(){
        //clean after every test
        System.out.println("Finished one test");
    }

    @AfterAll
    public static void cleanAfterAllTest(){
        //cleanup after all tests
        System.out.println("Finished all test");
    }

    @Test()
//    @Timeout(value = 10)
    public void testRegisterUser() {
        //Arrange
        UserR userForTesting = UserR.builder().id(1).name("Jhon").build();
        //Act
        String result = userRegistrationService.registerUser(userForTesting);
        //Assert
        Assertions.assertNotNull(result);
    }

    @Test
    public void testRegisterUserThrowsExceptionWhenUserIsNull() {
        UserR userForTesting = null;

        IllegalArgumentException exception = Assertions
                .assertThrows(IllegalArgumentException.class,
                        () -> userRegistrationService.registerUser(userForTesting),
                        "Expected IllegalArgumentException to be thrown :(");


        Assertions.assertEquals("User can not be null.",exception.getMessage());
        System.out.println("Test succeded//");

    }

    @Test
    public void testRegisterUserWithEmailConfirmation() {
        // GIVEN/Arrange
        UserR userForTesting = UserR.builder().id(1).name("Jhon").build();
        when(emailService.sendConfirmationEmail(userForTesting.getName())).thenReturn("Email was sent.");

        // WHEN
        userRegistrationService.registerUser(userForTesting);

        //THEN
        Mockito.verify(emailService, Mockito.times(1)).sendConfirmationEmail(userForTesting.getName());
    }
}
