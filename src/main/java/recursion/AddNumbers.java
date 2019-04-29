package recursion;

public class AddNumbers {

    public static void main(String[] args) {

        int add = add(4);
        System.out.println(add);
    }

    static int add(int num) {
        if (num == 0) {
            return 0;
        }
        return num + add(num - 1);
    }
}


