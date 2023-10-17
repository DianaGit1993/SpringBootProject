package org.example.Ex1;

import org.example.Ex1.StringManipulation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperationTest {
    private StringManipulation operations = new StringManipulation();

    @Test
    public void reverseStringTest() {
        String result = operations.reverse("Independent");
        Assertions.assertEquals("tnednepednI", result);
    }
}
