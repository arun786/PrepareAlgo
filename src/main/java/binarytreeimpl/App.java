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




    }
}
