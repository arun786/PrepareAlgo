package recursion;

public class FactorialNumber {

    public static void main(String[] args) {

        int factorial = factorial(4);
        System.out.println(factorial);
    }

    static int factorial(int num) {
        return num == 0 || num == 1 ? 1 : num * factorial(num - 1);
    }
}
