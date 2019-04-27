package binarytreeimpl;

public class App {

    public static void main(String[] args) {
        Tree<Integer> bst = new BST<>();
        bst.insertTree(10);
        System.out.println(bst);

        bst.insertTree(5);
        System.out.println(bst);

        bst.insertTree(15);
        System.out.println(bst);

        bst.insertTree(12);
        System.out.println(bst);

        bst.insertTree(19);
        System.out.println(bst);

        bst.insertTree(9);
        System.out.println(bst);

        Integer max = bst.getMax();
        System.out.println(max);

        Integer min = bst.getMin();
        System.out.println(min);

        bst.traversal();
    }
}
