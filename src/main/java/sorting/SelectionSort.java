package sorting;

public class SelectionSort {

    public static void main(String[] args) {

        int num[] = {1, 3, -2, 6, -5, 6, 9, 0};
        Util.display(num);
        selectionSort(num);
        Util.display(num);


    }

    public static void selectionSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int index = i;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[index] > nums[j]) {
                    index = j;
                }
            }

            if (index != i) {
                Util.swap(nums, index, i);
            }

            Util.display(nums);
        }


    }


}
