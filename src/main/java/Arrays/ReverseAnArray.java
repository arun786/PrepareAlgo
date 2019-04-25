package Arrays;

public class ReverseAnArray {

    public static void main(String[] args) {
        int[] numbers = {10,20};

        int startIndex = 0;
        int endIndex = numbers.length - 1;

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println();
        while (startIndex < endIndex) {
            swap(startIndex, endIndex, numbers);
            startIndex++;
            endIndex--;
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

    }

    private static void swap(int startIndex, int endIndex, int[] numbers) {
        int temp = numbers[startIndex];
        numbers[startIndex] = numbers[endIndex];
        numbers[endIndex] = temp;
    }
}
