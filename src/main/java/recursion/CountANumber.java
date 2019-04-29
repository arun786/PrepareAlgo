package recursion;

public class CountANumber {

    public static void main(String[] args) {

        int i = count5(1233432323, 3);
        System.out.println(i);
    }

    private static int count5(int number, int count) {
        if (number <= 9) {
            if (number == count) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (number % 10 == count) {
                return 1 + count5(number / 10, count);
            } else {
                return count5(number / 10, count);
            }
        }
    }
}
