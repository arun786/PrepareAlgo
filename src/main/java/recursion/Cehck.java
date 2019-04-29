package recursion;

public class Cehck {

    public static void main(String[] args) {

        int fibo = fibo(5);
        System.out.println(fibo);
    }

    static int fibo(int num) {
        if (num == 1) {
            return 1;
        }

        int fibo = fibo(num - 1);
        System.out.println("num  = "+ num + " :" + fibo);

        int fibo1 = fibo(num - 1);
        System.out.println("num1  = "+ num + " :" + fibo1);
        return fibo + fibo1;
    }
}
