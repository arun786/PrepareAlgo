package algorithms;

public class TowerOfHanoi {

    public static void solveHanoi(int n, char from, char middle, char to) {
        if (n == 1) {
            System.out.println("Plate 1 from " + from + " to " + to);
            return;
        }

        solveHanoi(n - 1, from, to, middle);
        System.out.println("Plate " + n + " from " + from + " to " + to);
        solveHanoi(n - 1, middle, from, to);
    }


    public static void main(String[] args) {
        TowerOfHanoi.solveHanoi(3, 'a', 'b', 'c');
    }
}
