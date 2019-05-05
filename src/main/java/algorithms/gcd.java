package algorithms;

public class gcd {
    public static void main(String[] args) {

        gcd gcd = new gcd();
        int gcd1 = gcd.gcd(10, 15);
        System.out.println(gcd1);
        int gcd2 = gcd.gcd(7, 9);
        System.out.println(gcd2);

        int gcdRecursive = gcd.gcdRecursive(10, 15);
        System.out.println(gcdRecursive);

    }

    private int gcd(int n1, int n2) {
        while (n2 != 0) {
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }
        return n1;
    }

    private int gcdRecursive(int n1, int n2) {
        if (n2 == 0) return n1;

        return gcdRecursive(n2, n1 % n2);
    }
}
