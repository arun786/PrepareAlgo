package binarytreeimpl;

import lombok.ToString;

@ToString
public class BST<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;


    @Override
    public void insertTree(T data) {

        if (root == null) {
            root = new Node<>(data);
        } else {
            insertNodeAt(data, root);
        }
    }

    @Override
    public T getMax() {

        T max = null;
        if (root == null) {
            System.out.println("No data present");
        } else {
            max = getMaxNode(root);
        }

        return max;
    }

    @Override
    public T getMin() {

        T min = null;
        if (root == null) {
            System.out.println("No data ");
        } else {
            min = getMinNode(root);
        }
        return min;
    }

    @Override
    public void traversal() {

        inorderTraversalNode(root);
    }

    public void inorderTraversalNode(Node<T> node) {

        if (node.getLeftChildNode() != null) {
            inorderTraversalNode(node.getLeftChildNode());
        }

        System.out.print(node + " ");

        if (node.getRightChildNode() != null) {
            inorderTraversalNode(node.getRightChildNode());
        }
    }


    private T getMinNode(Node<T> node) {

        if (node.getLeftChildNode() != null) {
            return getMinNode(node.getLeftChildNode());
        }

        return node.getData();
    }

    private T getMaxNode(Node<T> node) {
        if (node.getRightChildNode() != null) {
            return getMaxNode(node.getRightChildNode());
        }

        return node.getData();
    }

    private void insertNodeAt(T data, Node<T> node) {

        //check the data is greater than node's data , the data will be stored on the right side else on the left side

        if (data.compareTo(node.getData()) > 0) {
            //this means it will go to the right side
            if (node.getRightChildNode() != null) {
                insertNodeAt(data, node.getRightChildNode());
            } else {
                Node<T> newNode = new Node<>(data);
                node.setRightChildNode(newNode);
            }
        } else {
            if (node.getLeftChildNode() != null) {
                insertNodeAt(data, node.getLeftChildNode());
            } else {
                Node<T> newNode = new Node<>(data);
                node.setLeftChildNode(newNode);
            }
        }
    }
}
