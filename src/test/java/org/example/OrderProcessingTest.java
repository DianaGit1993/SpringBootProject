package org.example;

import org.example.testexamples.Order;
import org.example.testexamples.OrderProcessing;
import org.example.testexamples.SMSNotification;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderProcessingTest {

    @Mock
    SMSNotification smsNotification;
    @InjectMocks
    private OrderProcessing orderProcessing = new OrderProcessing(smsNotification);
    @Test
    public void testOrderProcessing(){
        Order order = Order.builder().id(1).customer("ion").product("phone").build();

        when(smsNotification.sendSMSNotification()).thenReturn("notification sent(mocked");

        //when/act
        orderProcessing.createOrder(order);

        //then/assert

        Mockito.verify(smsNotification, Mockito.times(1)).sendSMSNotification();



    }
}
