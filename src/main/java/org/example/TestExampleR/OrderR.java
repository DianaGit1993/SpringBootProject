package org.example.TestExampleR;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class OrderR
{
        private long id;
        private String customer;
        private String product;
}
