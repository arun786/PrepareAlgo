package recursion;

public class PrintNumbersFrom5to1 {

    public static void main(String[] args) {

        printNum(5);

        //int catsEye = catsEye(10);
        //System.out.println(catsEye);
        System.out.println(power(2, 3));
    }


    static void printNum(int num) {
        if (num == 0) {
            return;
        }

        System.out.println(num);
        printNum(num - 1);

    }

    static int catsEye(int cats) {

        if (cats == 0) {
            System.out.println("inside cats base condition");
            return 0;
        }

        System.out.println("stack of cats " + cats);
        int catsEye = catsEye(cats - 1);

        System.out.println("catsEye " + catsEye);

        int sum = 2 + catsEye;

        System.out.println("sum " + sum);

        return sum;
    }

    /**
     * to find the power of any number
     */

    static int power(int base, int power) {
        if (power == 1) {
            return base;
        }

        return base * power(base, power - 1);
    }
}


