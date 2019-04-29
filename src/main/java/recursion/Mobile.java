package recursion;

public class Mobile {

    public static void main(String[] args) {

        System.out.println(noSpeaker(4));
    }


    static int noSpeaker(int mobile) {
        if (mobile == 0) return 0;

        if (mobile % 2 == 0) {
            return 2 + noSpeaker(mobile - 1);
        }

        return 1 + noSpeaker(mobile - 1);
    }
}
