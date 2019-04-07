package Simple;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        /**
         * generates a random number between 0 and the argument specified
         */
        int i = random.nextInt(20);
        System.out.println(i);
    }
}
