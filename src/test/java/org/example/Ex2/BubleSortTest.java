package org.example.Ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BubleSortTest {
    private final BubbleSort bubbleSort = new BubbleSort();

    @Test
    public void bubleSortTest() {
        int[] toSort = {12, 5, 8, 1, 61, 37};

        bubbleSort.sort(toSort);
        Assertions.assertArrayEquals(toSort, new int[]{1, 5, 8, 12, 37, 61});

    }
}
