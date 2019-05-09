package sorting;

public class BubbleSort {


    public static void main(String[] args) {
        int num[] = {1, 5, 2, 7, 9, 12, 45};

        ptint(num);

        System.out.println();

        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length - 1 - i; j++) {
                if (num[j] > num[j + 1]) {
                    swap(num, j, j + 1);
                }
            }
        }

        ptint(num);
    }

    private static void ptint(int[] num) {
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }

    private static void swap(int[] num, int j, int i) {
        int temp = num[j];
        num[j] = num[i];
        num[i] = temp;
    }

}


