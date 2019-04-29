package binarytreeimpl;

public class AppforKthItem {

    public static void main(String[] args) {

        Tree<Integer> tree = new BST<>();
        tree.insertTree(12);
        tree.insertTree(10);
        tree.insertTree(5);
        tree.insertTree(1);
        tree.insertTree(11);
        tree.insertTree(15);
        tree.insertTree(50);
        tree.insertTree(45);


        tree.traversal();

        System.out.println();
        Node<Integer> smallest = tree.getKthSmallest(tree.getRoot(), 3);
        System.out.println(smallest.getData());


    }
}
