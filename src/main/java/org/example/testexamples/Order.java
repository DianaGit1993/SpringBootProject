package org.example.testexamples;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Order {
    private long id;
    private String customer;
    private String product;
}
