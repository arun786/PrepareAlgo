package recursion;

public class SumOfDigit {

    public static void main(String[] args) {

        int sum = sum(56);
        System.out.println(sum);


    }

    static int sum(int number) {
        if (number <= 9) return number;

        return number % 10 + sum(number / 10);
    }
}
