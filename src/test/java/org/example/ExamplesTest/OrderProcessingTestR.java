package org.example.ExamplesTest;

import org.example.Examples.OrderProcessingR;
import org.example.Examples.OrderR;
import org.example.Examples.SMSNotificationR;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.DoubleStream;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderProcessingTestR {
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
