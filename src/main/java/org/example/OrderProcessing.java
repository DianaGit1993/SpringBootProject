package org.example;

public class OrderProcessing {

    private SMSNotification smsNotification;

    OrderProcessing(SMSNotification smsNotification){
        this.smsNotification = smsNotification;
    }

    public String createOrder(Order order){
        System.out.println("Order details: " + order);

        //stores order to db
        // updates the stock
        String confirmation = smsNotification.sendSMSNotification();
        System.out.println(confirmation);
        return order.toString();
    }
}
