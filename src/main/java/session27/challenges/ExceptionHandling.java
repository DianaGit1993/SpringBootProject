package session27.challenges;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <h1>Exercise 3: Testing Exception Handling</h1>
 * <ol><li>Identify a class or method that throws exceptions under specific conditions
 * (e.g., validation errors, file not found, network errors, etc.).</li>
 * <li>Write test cases using JUnit to verify that the exceptions are correctly
 * thrown when the expected conditions are met. </li>
 * <li>Use JUnit assertions to check the exception type and the exception message.</li></ul>
 **/
public class ExceptionHandling {

    private final int SCALE = 324;

    public BigDecimal divide(Double dividend, Double divisor) throws ArithmeticException {

        if (divisor == 0.0) throw new ArithmeticException("Divisor can't be 0!");

        return BigDecimal.valueOf(dividend)
                .divide(BigDecimal.valueOf(divisor), SCALE, RoundingMode.HALF_UP);
    }

    public BigDecimal power(Double base, Double exponent)
            throws ArithmeticException, NumberFormatException {

        boolean isExponentNegative = exponent < 0.0;

        if (base == 0.0 && isExponentNegative)
            throw new ArithmeticException("Operation resulted in division by zero!");

        BigDecimal bdResult = BigDecimal.valueOf(base).pow(Math.abs(exponent.intValue()));
        if (! new NumberChecker().isDouble(bdResult.toString()))
            throw new NumberFormatException("Result overflows the type DOUBLE range.");

        return (isExponentNegative)
                ? BigDecimal.ONE.divide(bdResult, SCALE, RoundingMode.HALF_UP)
                : bdResult;
    }
}

/**
 * Number checking class.
 */
class NumberChecker {
    public boolean isDouble(String value) {
        BigDecimal bdValue = new BigDecimal(value.replace('-', '+'));
        return bdValue.subtract(BigDecimal.valueOf(Double.MIN_VALUE)).signum() >= 0
                && bdValue.subtract(BigDecimal.valueOf(Double.MAX_VALUE)).signum() <= 0
                || bdValue.signum() == 0;
    }

    public boolean isNumber(String value) {
        String sPattern = "[-+]?([0-9]*[.])?\\d+([eE][-+]?\\d+)?";
        return value.trim().matches(sPattern);
    }
}
