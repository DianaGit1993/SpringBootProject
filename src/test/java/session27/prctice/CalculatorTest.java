package session27.prctice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session27.practice.Calculator;

class CalculatorTest {
    private Calculator calculator = new Calculator();
    @Test
    void testAddNumbers() {
        int result = calculator.addNumbers(2,30);
        Assertions.assertEquals(31, result);
    }

    @Test
    void testMultiplyNumbers() {
        int result = calculator.multiplyNumbers(3, 7);
        Assertions.assertEquals(21, result);
    }
}