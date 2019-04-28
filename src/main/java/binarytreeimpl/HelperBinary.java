package binarytreeimpl;

public class HelperBinary<T extends Comparable<T>> {

    public boolean compare(Node<T> node1, Node<T> node2) {
        if (node1 == null || node2 == null) return node1 == node2;

        if (node1.getData().compareTo(node2.getData()) != 0) return false;

        return compare(node1.getLeftChildNode(), node2.getLeftChildNode()) && compare(node1.getRightChildNode(), node2.getRightChildNode());
    }
}
