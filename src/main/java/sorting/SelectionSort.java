package sorting;

public class SelectionSort {

    public static void main(String[] args) {

        int numbers[] = {7, 3, 8, 4, 9, 1};
        display(numbers);
        selectionSort(numbers);
        display(numbers);
    }


    public static void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int index = i;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    index = j;
                }
            }

            if (i != index) {
                swap(numbers, i, index);
            }
        }
    }

    public static void display(int numbers[]) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println();
    }

    private static void swap(int[] numbers, int i, int index) {
        int temp = numbers[i];
        numbers[i] = numbers[index];
        numbers[index] = temp;
    }


}
