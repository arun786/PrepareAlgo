package sorting;

import static sorting.Util.swap;

public class ShellSort {


    public static void main(String[] args) {


        int num[] = {1, 3, -2, 6, -5, 6, 9, 0};
        Util.display(num);
        shellSort(num);
        Util.display(num);

    }


    static void shellSort(int[] numbers) {


        /**
         * identify the gap, which will start with half the array size, say if we have array of size 10,
         * gap will be 5. and then it will reduce by 2.
         */

        for (int gap = numbers.length / 2; gap > 0; gap /= 2) {

            /**
             * second iteration will start from gap, say from 5 and then increment every time by 1
             */
            for (int i = gap; i < numbers.length; i++) {

                int j = i;
                /**
                 *
                 */
                while (j >= gap && numbers[j - gap] > numbers[j]) {
                    swap(numbers, j - gap, j);
                    j = j - gap;
                }
            }

        }


    }
}
