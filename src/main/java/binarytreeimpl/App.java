package binarytreeimpl;

public class App {

    public static void main(String[] args) {
        Tree<Integer> bst = new BST<>();
        bst.insertTree(10);
        bst.insertTree(5);
        bst.insertTree(15);
        bst.insertTree(12);
        bst.insertTree(19);
        bst.insertTree(13);
        bst.insertTree(14);
        bst.insertTree(9);
        Integer max = bst.getMax();
        System.out.println(max);

        Integer min = bst.getMin();
        System.out.println(min);

        bst.traversal();
        System.out.println();

        bst.delete(9);
        bst.traversal();
        System.out.println();
        bst.delete(12);
        bst.traversal();


        Tree<Integer> bst1 = new BST<>();
        bst1.insertTree(10);
        bst1.insertTree(15);
        bst1.insertTree(12);
        bst1.insertTree(18);
        bst1.insertTree(7);
        bst1.insertTree(5);
        Tree<Integer> bst2 = new BST<>();

        bst2.insertTree(10);
        bst2.insertTree(15);
        bst2.insertTree(12);
        bst2.insertTree(18);
        bst2.insertTree(7);
        bst2.insertTree(5);

        System.out.println();
        HelperBinary<Integer> helperBinary = new HelperBinary<>();
        boolean compare = helperBinary.compare(bst1.getRoot(), bst2.getRoot());
        System.out.println(compare);


    }
}
