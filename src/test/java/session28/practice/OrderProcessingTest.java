package session28.practice;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderProcessingTest {
    @Mock
    private SMSNotification smsNotification;

    @InjectMocks
    private OrderProcessing orderProcessing = new OrderProcessing(smsNotification);

    @BeforeAll
    public static void setUp(){
        System.out.println("Running tests for OrderProcessing...");
    }

    @AfterEach
    public void cleanAfterTest() {
        // clean up after all test
        System.out.println("Finished one test.");
    }

    @AfterAll
    public static void cleanAfterAllTests() {
        // clean up after every test
        System.out.println("Finished all tests.");
    }

    @BeforeEach
    public void beforeEveryTest(){
        System.out.println("Starting new test...");
    }

    @Test
//    @Timeout(value = 1200, unit = TimeUnit.MILLISECONDS)
    public void testOrderProcessing() {

        // given/arrange
        Order order = Order.builder()
                .id(1)
                .Product("iPhone")
                .customer("John")
                .build();

        when(smsNotification.sendSMSNotification()).thenReturn("Notification sent (mocked)");

        // when/act
        orderProcessing.createOrder(order);

        // then/assert
        Mockito.verify(smsNotification,Mockito.times(1)).sendSMSNotification();
    }

}
