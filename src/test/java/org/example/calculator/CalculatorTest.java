package org.example.calculator;

import org.example.testexamples.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator  = new Calculator();
    @Test
    public void testAddingNumbers(){
        int result = calculator.addNumbers(2, 30);
        Assertions.assertEquals(32, result);
    }

    @Test
    public void testMultiplyingNumbers(){
        int result = calculator.multiplyNumbers(3, 7);
        Assertions.assertEquals(21, result);
    }

    @Test
    public void testMultiplyingNegativeNumbers(){
        int result = calculator.multiplyNumbers(-3, -7);
        Assertions.assertEquals(21, result);
    }
}
