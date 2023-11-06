package org.example.calculator;

import org.example.Examples.calculator.CalculatorR;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTestR
{
    private CalculatorR calculator=new CalculatorR();
    @Test
    public void testAddingNumbers()
    {
       int result= calculator.addNumbers(2,30);
        Assertions.assertEquals(32,result);
    }
    public void testMultiplyingNumbers()
    {
        int result= calculator.multiplyNumbers(3,7);
        Assertions.assertEquals(21,result);
    }

}