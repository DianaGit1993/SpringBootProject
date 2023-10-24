package org.example.testexamples;

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


//    @BeforeAll //@Before for other JUnit versions
//    public void beforeEveryTest(){
//        System.out.println("Starting new test");
//    }
//
//    @BeforeAll //@BeforeClass for other JUnit versions
//    public static void setUp(){
//        System.out.println("Running test for UserRegistrationService...");
//    }
//    @AfterEach
//    public void cleanAfterTest(){
//        //clean after every test
//        System.out.println("Finished one test");
//    }
//
//    @AfterAll
//    public static void cleanAfterAllTest(){
//        //cleanup after all tests
//        System.out.println("Finished all test");
//    }



    @Test
    public void testRegisterUser() {
        User userForTesting = User.builder().id(1).name("Jhon").build();

        String result = userRegistrationService.registerUser(userForTesting);

        Assertions.assertNotNull(result);
    }

    @Test
    public void testRegisteredUsedThrowsExceptionWhenUserIsNull(){
        User userForTesting=null;

        IllegalArgumentException exception=Assertions
                .assertThrows(IllegalArgumentException.class,
                        ()->userRegistrationService.registerUser(userForTesting),
                        "Expected IllegalArgumentException to be thrown.");

        Assertions.assertEquals("User can not be null.",exception.getMessage());
        System.out.println("Test succeeded");

    }

    @Test
    public void testRegisteredUsedWithEmailConfirmation(){
        //GIVEN/Arrange
        User userForTesting=User.builder().id(1).name("Jhon").build();
        when(emailService.sendConfirmationEmail(userForTesting.getName())).thenReturn("Email was sent");

        //When
        userRegistrationService.registerUser(userForTesting);

        //then
        Mockito.verify(emailService,Mockito.times(1)).sendConfirmationEmail(userForTesting.getName());
    }
}
