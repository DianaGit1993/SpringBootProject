package org.example;

import com.sun.source.tree.ModuleTree;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Or;
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
