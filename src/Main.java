import algorithms.sorting.SortingAlgo;

public class Main {
    public static void main(String[] args) {
        SortingAlgo algo = new SortingAlgo();


        int[] array = {5, 1, 2, 4, 3, 7, 6};
        algo.insertionSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }


    }
}