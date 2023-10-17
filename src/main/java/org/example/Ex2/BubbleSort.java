package org.example.Ex2;

public class BubbleSort {
    public void sort(int[] array) {


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length -1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
/*temp = gol;
array[j] = cola;
array[j+1] = fanta;

temp = array[j];
array[j] = array[j+1];
array[j+1] = temp;
 */
