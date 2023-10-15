package session27.challenges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 * <h1>Exercise 2: Testing a Sorting Algorithm</h1>
 * <ol><li>Choose a sorting algorithm (e.g., bubble sort, insertion sort, quicksort, etc.).</li>
 * <li>Implement the sorting algorithm in a separate class or method.</li>
 * <li>Write test cases using JUnit to verify the correctness and efficiency of the sorting algorithm.</li>
 * <li>Use JUnit assertions to check that the input arrays are sorted in the expected order.</li></ul>
 **/
public class BubbleSortTest {
    private final BubbleSort<String> stringBubbleSort = new BubbleSort<>();
    private final BubbleSort<Long> longBubbleSort = new BubbleSort<>();
    private final BubbleSort<Double> doubleBubbleSort = new BubbleSort<>();

    @Test
    void givenNullStringArray_WhenSort_ThenNullStringArray() {

        String[] input = null;
        stringBubbleSort.sort(input);

        String[] expectedResult = null;

        int counter = 0;

        Assertions.assertArrayEquals(input, expectedResult, "Failed at step " + ++counter);
    }

    @Test
    void givenStringArray_WhenSort_ThenNaturallySortedStringArray() {

        String[] input = {"de", "a", "r", "q", "bb"};
        stringBubbleSort.sort(input);

        String[] expectedResult = {"a", "bb", "de", "q", "r"};

        int counter = 0;

        Assertions.assertArrayEquals(input, expectedResult, "Failed at step " + ++counter);
    }

    @Test
    void givenStringArray_WhenSort_ThenReversedSortedStringArray() {

        BubbleSort<String> stringRevBubbleSort = new BubbleSort<>(Comparator.reverseOrder());

        String[] input = {"de", "a", "r", "q", "bb"};
        stringRevBubbleSort.sort(input);

        String[] expectedResult = {"r", "q", "de", "bb", "a"};

        int counter = 0;

        Assertions.assertArrayEquals(input, expectedResult, "Failed at step " + ++counter);
    }

    @Test
    void givenNullIntArray_WhenSort_ThenNullIntArray() {

        Long[] input = null;
        longBubbleSort.sort(input);

        Long[] expectedResult = null;

        int counter = 0;

        Assertions.assertArrayEquals(input, expectedResult, "Failed at step " + ++counter);
    }

    @Test
    void givenLongArray_WhenSort_ThenNaturallySortedLongArray() {

        Long[] input = {Long.MAX_VALUE, 1258793L, 2587L, 12L, 0L, Long.MIN_VALUE};
        longBubbleSort.sort(input);

        Long[] expectedResult = {Long.MIN_VALUE, 0L, 12L, 2587L, 1258793L, Long.MAX_VALUE};

        int counter = 0;

        Assertions.assertArrayEquals(input, expectedResult, "Failed at step " + ++counter);
    }

    @Test
    void givenLongArray_WhenSort_ThenReversedSortedLongArray() {

        BubbleSort<Long> longRevBubbleSort = new BubbleSort<>(Comparator.reverseOrder());

        Long[] input = {Long.MAX_VALUE, 1258793L, 12L, 0L, 2587L, Long.MIN_VALUE};
        longRevBubbleSort.sort(input);

        Long[] expectedResult = {Long.MAX_VALUE, 1258793L, 2587L, 12L, 0L, Long.MIN_VALUE};

        int counter = 0;

        Assertions.assertArrayEquals(input, expectedResult, "Failed at step " + ++counter);
    }

    @Test
    void givenNullDoubleArray_WhenSort_ThenNullDoubleArray() {

        Double[] input = null;
        doubleBubbleSort.sort(input);

        Double[] expectedResult = null;

        int counter = 0;

        Assertions.assertArrayEquals(input, expectedResult, "Failed at step " + ++counter);
    }

    @Test
    void givenDoubleArray_WhenSort_ThenNaturallySortedDoubleArray() {

        Double[] input = {Double.MAX_VALUE, 1258793.01, 12.012, 0.0, 2587.0, Double.MIN_VALUE};
        doubleBubbleSort.sort(input);

        Double[] expectedResult = {0.0, Double.MIN_VALUE, 12.012, 2587.0, 1258793.01, Double.MAX_VALUE};

        int counter = 0;

        Assertions.assertArrayEquals(input, expectedResult, "Failed at step " + ++counter);
    }

    @Test
    void givenDoubleArray_WhenSort_ThenReversedSortedDoubleArray() {

        BubbleSort<Double> doubleRevBubbleSort = new BubbleSort<>(Comparator.reverseOrder());

        Double[] input = {Double.MAX_VALUE, 1258793.01, 12.012, 0.0, 2587.0, Double.MIN_VALUE};
        doubleRevBubbleSort.sort(input);

        Double[] expectedResult = {Double.MAX_VALUE, 1258793.01, 2587.0, 12.012, Double.MIN_VALUE, 0.0};

        int counter = 0;

        Assertions.assertArrayEquals(input, expectedResult, "Failed at step " + ++counter);
    }
}
