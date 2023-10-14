package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void testAddingNumbers(){
        int result = calculator.addNumbers(3,39);
        Assertions.assertEquals(41, result);

    }
    @Test
    public void testMultiplyingNumbers(){
        int result = calculator.multiplyNumbers(2, 3);
        Assertions.assertEquals(6, result);

    }
}
