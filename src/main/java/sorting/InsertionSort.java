package sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int num[] = {1, 3, -2, 6, -5, 6, 9, 0};
        Util.display(num);
        insertionSort(num);
    }


    static void insertionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {
                Util.swap(nums, j, j - 1);
                j--;
            }
            System.out.print("After " + i + " iteration ");
            Util.display(nums);
        }
    }
}
