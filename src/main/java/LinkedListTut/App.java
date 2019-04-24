package LinkedListTut;

public class App {

    public static void main(String[] args) {
        List<String> lstString = new LinkedList<>();
        lstString.insert("arun");
        System.out.println(lstString);
        lstString.insert("Adwiti");
        System.out.println(lstString);
        lstString.insert("Pushpa");
        System.out.println(lstString);


        System.out.println("---reverse----");
        lstString.reverse();
        System.out.println(lstString);


        System.out.println("-----Get the middle node");
        String middle = lstString.middle();
        System.out.println(middle);

        System.out.println("---------------");
        System.out.println("Insert at the end");
        List<Integer> numbers = new LinkedList<>();
        numbers.insertAtEnd(10);
        System.out.println(numbers);
        numbers.insertAtEnd(12);
        System.out.println(numbers);



        lstString.delete("Pushpa");
        System.out.println(lstString);

        System.out.println("Traversing");
        lstString.traverse();

        System.out.println("-----Get the middle node");
        middle = lstString.middle();
        System.out.println(middle);


        System.out.println("---reverse----");
        lstString.reverse();
        System.out.println(lstString);
    }
}
