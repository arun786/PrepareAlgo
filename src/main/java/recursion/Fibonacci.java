package recursion;

public class Fibonacci {

    public static void main(String[] args) {

        //int fibo = fibo(5);
        System.out.println();
        //System.out.println(fibo);

        System.out.println(fiboWithoutRecurssion(7));

    }


    static int fiboWithoutRecurssion(int x) {

        int sum = 1;
        int previousSum = 0;
        int index = 0;

        System.out.println(previousSum);
        System.out.println(sum);
        while (index < x - 2) {

            int temp = sum;
            sum = sum + previousSum;
            System.out.println(sum);
            previousSum = temp;
            index++;
        }

        return sum;
    }


    static int fibo(int num) {
        if (num == 0) {
            //System.out.print(num + " ");
            return 0;
        }
        if (num == 1) {
            //System.out.print(num + " ");
            return 1;
        }

        int fibo = fibo(num - 1);
        System.out.println("furst " + fibo);
        int fibo1 = fibo(num - 2);

        System.out.println("second " + fibo1);
        int sum = fibo + fibo1;
        //System.out.print(sum + " ");
        return sum;
    }
}
