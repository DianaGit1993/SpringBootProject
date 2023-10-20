package org.example.testExampleR;

import org.example.TestExampleR.OrderR;
import org.example.TestExampleR.OrderProcessingR;
import org.example.TestExampleR.SMSNotificationR;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderProcesingTest {
    @Mock
    SMSNotificationR smsNotification;

    @InjectMocks
    private OrderProcessingR orderProcessing = new OrderProcessingR(smsNotification);

    @Test
    public void testOrderProcessing(){
        // given/arrange
        OrderR order = OrderR.builder()
                .id(1)
                .customer("Jhon")
                .product("Iphone")
                .build();
        when(smsNotification.sendSMSNotification()).thenReturn("Notification Sent (mocked)");

        // when/act
        orderProcessing.createOrder(order);

        // then/assert
        Mockito.verify(smsNotification, Mockito.times(1)).sendSMSNotification();
    }

}