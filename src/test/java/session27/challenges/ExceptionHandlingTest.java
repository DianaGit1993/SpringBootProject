package session27.challenges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * <h1>Exercise 3: Testing Exception Handling</h1>
 * <ol><li>Identify a class or method that throws exceptions under specific conditions
 * (e.g., validation errors, file not found, network errors, etc.).</li>
 * <li>Write test cases using JUnit to verify that the exceptions are correctly
 * thrown when the expected conditions are met. </li>
 * <li>Use JUnit assertions to check the exception type and the exception message.</li></ul>
 **/
public class ExceptionHandlingTest {
    private final ExceptionHandling eh = new ExceptionHandling();

    @Test
    void givenZeroDivisor_WhenDivide_ThenArithmeticExceptionIsThrown() {
        double dividend = 1.0, divisor = 0;
        Assertions.assertThrows(ArithmeticException.class, () -> eh.divide(dividend, divisor));
    }

    @Test
    void givenZeroBaseAndNegativeExponent_WhenPower_ThenArithmeticExceptionIsThrown() {
        double base = 0.0, exponent = -10.0;
        Assertions.assertThrows(ArithmeticException.class, () -> eh.power(base, exponent));
    }

    @Test
    void givenBigPositiveValuesOperands_WhenPower_ThenNumberFormatExceptionIsThrown() {
        double base = 1234.0, exponent = 1234.1;
        Assertions.assertThrows(NumberFormatException.class, () -> eh.power(base, exponent));
    }
}
