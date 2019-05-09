package Map;

import java.util.HashMap;

public class TwoSumProblem {

    public static void main(String[] args) {
        int[] numbers = {3, 5, 2, -4, 8, 11, 0};
        int sum = 8;

        Sum sum1 = new Sum(sum, numbers);
        sum1.solve();
    }
}


class Sum {
    private int numberProvided;
    private int[] numbers;

    public Sum(int numberProvided, int[] numbers) {
        this.numberProvided = numberProvided;
        this.numbers = numbers;
    }


    public void solve() {

        HashMap<Integer, Integer> check = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {


            int remainder = numberProvided - numbers[i];

            if (check.containsValue(remainder)) {
                System.out.println("the combination " + numbers[i] + " , " + remainder);
            }

            check.put(i, numbers[i]);
        }
    }
}
