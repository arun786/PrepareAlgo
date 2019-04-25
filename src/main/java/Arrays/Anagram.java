package Arrays;

import java.util.Collections;

public class Anagram {

    public static void main(String[] args) {

        String first = "dude";
        String second = "udde";


    }


    public boolean anagram(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        return true;
    }
}
