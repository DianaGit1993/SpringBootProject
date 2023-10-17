package session28.practice;

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
    EmailService emailService;

    @InjectMocks
    UserRegistrationService userRegistrationService = new UserRegistrationService(emailService);

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
        // cleanup after every test
        System.out.println("Finished one test");
    }


    @AfterAll
    public static void cleanAfterAllTests(){
        // cleanup after all tests
        System.out.println("Finished all tests");
    }

    @Test
//    @Timeout(value = 10)
    public void testRegisterUser() {
        // Arrange
        User userForTesting = User.builder().id(1).name("John").build();
        // Act
        String result = userRegistrationService.registerUser(userForTesting);
        // Assert
        Assertions.assertNotNull(result);
    }

    @Test
    public void testRegisterUserThrowsExceptionWhenUserIsNull() {
        User userForTesting = null;

        IllegalArgumentException exception = Assertions
                .assertThrows(IllegalArgumentException.class,
                        () -> userRegistrationService.registerUser(userForTesting),
                        "Expected IllegalArgumentException to be thrown :(");


        Assertions.assertEquals("User can not be null.", exception.getMessage());
        System.out.println("Test succeeded.");

    }

    @Test
    public void testRegisterUserWithEmailConfirmation() {
        // Given/Arrange
        User userForTesting = User.builder().id(1).name("John").build();
        when(emailService.sendConfirmationEmail(userForTesting.getName())).thenReturn("Email was sent.");

        userRegistrationService.registerUser(userForTesting);

        Mockito.verify(emailService, Mockito.times(1)).sendConfirmationEmail(userForTesting.getName());

    }
}