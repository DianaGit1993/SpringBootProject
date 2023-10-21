package challenge;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Challenge2Test {

    @Test
    public void testBubbleSort(){

        // Test case 1: Basic test with an unsorted array
        int[] arr1 = {5, 3, 1, 4, 2};
        int[] sorted1 = BubbleSort.sort(arr1);
        int[] expected1 = {1,2,3,4,5};
        assertArrayEquals(expected1, sorted1);

        // Test case 2: Test with an already sorted array
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] sorted2 = BubbleSort.sort(arr2);
        int[] expected2 = {1, 2, 3, 4, 5};
        assertArrayEquals(expected2, sorted2);

        // Test case 3: Test with an empty array
        int[] arr3 = {};
        int[] sorted3 = BubbleSort.sort(arr3);
        int[] expected3 = {};
        assertArrayEquals(expected3, sorted3);
    }
}
