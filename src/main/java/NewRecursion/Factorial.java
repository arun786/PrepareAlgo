package NewRecursion;

public class Factorial {

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        int factorial1 = factorial.factorial(5);
        System.out.println(factorial1);
    }

    public int factorial(int k) {

        return factorial(1, k);
    }

    private int factorial(int accumulator, int k) {


        if (k == 1) return accumulator;

        return factorial(k * accumulator, k - 1);

    }
}
