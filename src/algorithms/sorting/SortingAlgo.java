package algorithms.sorting;

public class SortingAlgo {

    private static boolean validateEmpty(int[] array) {
        return array == null || array.length == 0;
    }

    //    WCP= O(n^2)
//    ACP= O(n^2)
//    SPACE C= O(1) one temp variable
    public void bubbleSort(int[] array) {
        if (validateEmpty(array)) return;
        int size = array.length, temp;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public void bubbleSortControlledSwap(int[] array) {
        if (validateEmpty(array)) return;
        int size = array.length, temp, swaps = 1;
        for (int i = 0; i < (size - 1) && swaps == 1; i++) {
            for (int j = 0; j < (size - i - 1); j++) {
                swaps = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swaps = 1;
                }
            }
        }
    }

    boolean more(int value1, int value2) {
        return value1 > value2;
    }

    public void insertionSort(int[] array) {
        if (validateEmpty(array)) return;
        int size = array.length, temp, j;
        for (int i = 1; i < size; i++) {
            temp = array[i];
            for (j = i; j > 0 && more(array[j - 1], temp); j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }


}
