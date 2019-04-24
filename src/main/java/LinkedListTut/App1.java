package LinkedListTut;

public class App1 {
    public static void main(String[] args) {

        List<Integer> numbers = new LinkedList<>();
        numbers.insert(10);
        numbers.insert(12);
        numbers.insert(13);
        numbers.insert(14);


        System.out.println(numbers);

        numbers.reverse();
        System.out.println(numbers);
    }
}
