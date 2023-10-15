package session27.challenges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * <h1>Exercise 2: Testing a Sorting Algorithm</h1>
 * <ol><li>Choose a sorting algorithm (e.g., bubble sort, insertion sort, quicksort, etc.).</li>
 * <li>Implement the sorting algorithm in a separate class or method.</li>
 * <li>Write test cases using JUnit to verify the correctness and efficiency of the sorting algorithm.</li>
 * <li>Use JUnit assertions to check that the input arrays are sorted in the expected order.</li></ul>
 **/
public class BubbleSort <T> {

    private Comparator<? super T> comparator;

    BubbleSort (Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    BubbleSort () {
        this((Comparator<? super T>) Comparator.naturalOrder());
    }

    public void sort(T[] array) {

        // Flag to stop unnecessary iterations
        boolean stop = false;

        int i = 0,
            len = (array != null && array.length > 0) ? array.length : 0;

        while (i < len) {
            // Sets the [stop] flag to TRUE.
            // The next FOR loop will change it if it finds two elements
            // that don't satisfy the comparator
            stop = true;
            for (int j = 1; j < len; j++) {
                if (Objects.compare(array[j - 1], array[j], comparator) > 0) {
                    T tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                    stop = false;
                }
            }
            if (stop) break;
            else i++;
        }
    }
}