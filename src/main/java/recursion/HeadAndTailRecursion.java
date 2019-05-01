package recursion;

public class HeadAndTailRecursion {

    public static void main(String[] args) {

        HeadAndTailRecursion headAndTailRecursion = new HeadAndTailRecursion();
        headAndTailRecursion.headRecursion(10);
        headAndTailRecursion.tailRecursion(10);
    }


    public void headRecursion(int n) {

        if (n == 1) return;
        System.out.println("The value of N : " + n);
        headRecursion(n - 1);
    }

    public void tailRecursion(int n) {
        if (n == 1) return;

        tailRecursion(n - 1);
        System.out.println("The value of N : " + n);
    }
}
