package Simple;

import java.util.Random;

public class ReservoirSamplingProblem {
    /**
     * Problem description
     * <p>
     * We need to select k random elements from an array where the array size is not known.
     * <p>
     * steps
     * <p>
     * 1. copy the specified k elements from 0 to k to new array from the original one
     * 2. iterate the original array starting from the k + 1 to the end of the array
     * 3. generate a random number from 0 to k + 1 and compare the index, if it less than k
     * 4. get the index which is more than k + 1 (iteration) and populate the new array with index generated using random number with
     * the value of the index.
     */

    private static Random random = new Random();

    public static int[] reservoirSamplingProblem(int[] actualArray, int numberOfElementsToBeSelected) {

        int[] reservoir = new int[numberOfElementsToBeSelected];
        /**
         * Copy the first numberOfElementsToBeSelected to the reservoir from the original array
         */
        for (int i = 0; i < numberOfElementsToBeSelected; i++) {
            reservoir[i] = actualArray[i];
        }

        for (int i = numberOfElementsToBeSelected + 1; i < actualArray.length; i++) {
            int j = random.nextInt(i) + 1;
            if (j < numberOfElementsToBeSelected) {
                reservoir[j] = actualArray[i];
            }
        }
        return reservoir;
    }

    public static void main(String[] args) {
        int[] original = {10, 20, 30, 40, 50, 55, 66, 77, 8, 3, 6, 8, 23, 234};

        int[] reservoir = reservoirSamplingProblem(original, 5);
        for (int i = 0; i < reservoir.length; i++) {
            System.out.println(reservoir[i]);
        }
    }
}
