package algorithms;

import java.util.Random;

public class QuickSelect {

    private int[] nums;

    public QuickSelect(int[] nums) {
        this.nums = nums;
    }

    public int select(int k) {
        return select(0, nums.length - 1, k - 1);
    }

    private int select(int firstIndex, int lastIndex, int k) {

        int pivot = partition(firstIndex, lastIndex);

        if (pivot > k) {
            return select(firstIndex, pivot - 1, k);
        } else if (pivot < k) {
            return select(pivot + 1, lastIndex, k);
        }

        return nums[k];
    }

    private int partition(int firstIndex, int lastIndex) {

        int pivot = new Random().nextInt(lastIndex - firstIndex + 1) + firstIndex;

        swap(pivot, lastIndex);

        for (int i = firstIndex; i < lastIndex; i++) {

            if (nums[i] < nums[lastIndex]) {
                swap(i, firstIndex);
                firstIndex++;
            }

        }
        swap(firstIndex, lastIndex);
        return firstIndex;
    }

    private void swap(int firstIndex, int lastIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[lastIndex];
        nums[lastIndex] = temp;
    }

    public static void main(String[] args) {
        int[] arrays = {1, 4, 2, 6, 8, -1};
        QuickSelect quickSelect = new QuickSelect(arrays);
        int select = quickSelect.select(1);
        System.out.println(select);
    }
}
