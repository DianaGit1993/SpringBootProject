package org.example.Test.Tema1.challenge2;

import org.example.Tema1.challenge2.SortingAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortingAlgorithmTest
{
    SortingAlgorithm sortingAlgorithm=new SortingAlgorithm();
    @Test
    public void testBubbleSort()
    {
        int[] v = {2, 6, 3, 9, 1, 8, 4};
        int[] result = sortingAlgorithm.bubbleSort(v);
        int[] expected = {1, 2, 3, 4, 6, 8, 9};
        Assertions.assertArrayEquals(expected, result);
    }
    @Test
    public void testSelectionSort()
    {
        int[] v = {2, 6, 3, 9, 1, 8, 4};
        int[] result = sortingAlgorithm.selectionSort(v);
        int[] expected = {1, 2, 3, 4, 6, 8, 9};
        Assertions.assertArrayEquals(expected, result);
    }
    @Test
    public void testExchangeSort()
    {
        int[] v = {2, 6, 3, 9, 1, 8, 4};
        int[] expected = {1, 2, 3, 4, 6, 8, 9};
        int[] result = sortingAlgorithm.exchangeSort(v); // Aici trebuie să sortezi vectorul

        Assertions.assertArrayEquals(expected, result);
    }



}
