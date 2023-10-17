package session28.practice;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class OrderProcessing {

    private SMSNotification smsNotification;

    public OrderProcessing(SMSNotification smsNotification) {
        this.smsNotification = smsNotification;
    }

    public String createOrder(Order order) {
        System.out.println("Order details: " + order);
        // stores the order to db
        // updates the stock
        smsNotification.sendSMSNotification();

        return order.toString();
    }

}

@Getter
@Setter
@Builder
@ToString
class Order {
    private long id;
    private String customer;
    private String Product;
}

class SMSNotification {
    public String sendSMSNotification() {
        // send SMS ...
        return "Oredr confirmed for product x";
    }
}