package org.example.testexamples;

import org.example.testexamples.Order;
import org.example.testexamples.OrderProcessing;
import org.example.testexamples.SMSNotification;
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
    SMSNotification smsNotification;

    @InjectMocks
    private OrderProcessing orderProcessing = new OrderProcessing(smsNotification);

    @Test
    public void testOrderProcessing(){
        // given/arrange
        Order order = Order.builder()
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
