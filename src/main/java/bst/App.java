package bst;

public class App {

    public static void main(String[] args) {
        Tree<String> tree = new BST<>();
        tree.insert("pushpa");
        tree.insert("arun");
        tree.insert("adwiti");
        tree.insert("xerox");
        tree.insert("queue");

        System.out.println(tree);

        tree.traverse();

        String max = tree.getMax();
        System.out.println();
        System.out.println("Highest value " + max);
        System.out.println();
        String min = tree.getMin();
        System.out.println("lowest value " + min);

        tree.delete("xerox");
        System.out.println(tree);
    }
}
