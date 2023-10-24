package org.example.Tema1.challenge2;

import java.lang.management.MonitorInfo;

public class SortingAlgorithm
{
    public int[] bubbleSort(int[] vector)
    {
        for (int i = 0; i < vector.length - 1; i++)
        {
            for (int j = 0; j < vector.length - i - 1; j++)
            {
                if (vector[j] > vector[j + 1])
                {
                    // Schimbă elementele
                    int aux = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = aux;
                }
            }
        }
        return vector;
    }
    public int[] selectionSort(int[] vector)
    {
        for (int i = 0; i < vector.length-1; i++)
        {
            int minIndex = i;
            for (int j = i+1; j < vector.length; j++)
            {
                if (vector[minIndex] > vector[j]) { // Modificarea corectă
                    minIndex = j;
                }
            }
            int aux = vector[i];
            vector[i] = vector[minIndex];
            vector[minIndex] = aux;
        }
        return vector; // Întoarce vectorul sortat
    }



    public int[] exchangeSort(int[] vector) {
        for (int i = 0; i < vector.length - 1; i++) {
            for (int j = i + 1; j < vector.length; j++) {
                if (vector[i] > vector[j]) {
                    int aux = vector[i];
                    vector[i] = vector[j];
                    vector[j] = aux;
                }
            }
        }
        return vector;
    }



}
