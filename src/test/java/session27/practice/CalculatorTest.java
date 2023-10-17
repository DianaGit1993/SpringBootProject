package session27.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private Calculator calculator = new Calculator();
    @Test
    void testAddNumbers() {
        int result = calculator.addNumbers(2,30);
        Assertions.assertEquals(32, result);
    }

    @Test
    void testMultiplyNumbers() {
        int result = calculator.multiplyNumbers(3, 7);
        Assertions.assertEquals(21, result);
    }
}