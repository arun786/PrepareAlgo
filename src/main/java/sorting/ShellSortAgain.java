package sorting;

import static sorting.Util.display;

public class ShellSortAgain {

    public static void main(String[] args) {


        int numbers[] = {10, 3, 5, 12, 89, 23, 45};
        display(numbers);
        shellSort(numbers);
        display(numbers);

    }

    public static void shellSort(int[] numbers) {

        //first get the gap, logic here is arraysize should be reduced by half every iteration
        //till we reach 1, where it is similar to Insertion sort

        for (int gap = numbers.length / 2; gap > 0; gap /= 2) {


            //you get the middle element, this loop will continue for each element
            // for the gap till it reaches the end of the array

            for (int i = gap; i < numbers.length / 2; i++) {
                int j = i;
                while (j >= gap && numbers[j - gap] > numbers[j]) {
                    swap(numbers, j - gap, j);
                    j = j - gap;
                }
            }
        }
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
