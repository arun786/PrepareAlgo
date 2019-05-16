package sorting;

public class Util {

    static void swap(int[] nums, int index, int i) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }

    static void display(int[] num) {
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }
}
