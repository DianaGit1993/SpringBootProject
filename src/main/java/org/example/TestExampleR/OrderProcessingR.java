package org.example.TestExampleR;

public class OrderProcessingR
{
    private SMSNotificationR smsNotification;

    public OrderProcessingR(SMSNotificationR smsNotification)
    {
        this.smsNotification = smsNotification;
    }

    public String createOrder(OrderR order)
    {
        System.out.println("Order details: " + order);

        //stores order to db
        // updates the stock
        String confirmation = smsNotification.sendSMSNotification();
        System.out.println(confirmation);
        return order.toString();
    }
}
