package AVI;

import lombok.ToString;

@ToString
public class AVL<T extends Comparable<T>> {

    private Node<T> root;

    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> node, T data) {

        if (node == null) {
            return new Node<>(data);
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(insert(node.getLeftChild(), data));
        } else {
            node.setRightChild(insert(node.getRightChild(), data));
        }

        int height = Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1;
        node.setHeight(height);

        node = balanceTree(node, data);

        return node;
    }

    private Node<T> balanceTree(Node<T> node, T data) {

        int balance = getBalance(node);

        if (balance > 1 && data.compareTo(node.getLeftChild().getData()) < 0) {
            return rightRotation(node);
        } else if (balance < -1 && data.compareTo(node.getRightChild().getData()) > 0) {
            return leftRotation(node);
        } else if (balance > 1 && data.compareTo(node.getLeftChild().getData()) > 0) {
            node.setLeftChild(leftRotation(node.getLeftChild()));
            return rightRotation(node);
        } else if (balance < -1 && data.compareTo(node.getRightChild().getData()) < 0) {
            node.setRightChild(rightRotation(node.getRightChild()));
            return leftRotation(node);
        }
        return node;
    }

    private Node<T> leftRotation(Node<T> node) {

        Node<T> newRoot = node.getRightChild();
        Node<T> leftChild = newRoot.getLeftChild();
        newRoot.setLeftChild(node);
        node.setRightChild(leftChild);

        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
        newRoot.setHeight(Math.max(height(newRoot.getLeftChild()), height(newRoot.getRightChild())) + 1);

        return newRoot;
    }

    private Node<T> rightRotation(Node<T> node) {

        Node<T> newRoot = node.getLeftChild();
        Node<T> rightChild = newRoot.getRightChild();
        newRoot.setRightChild(node);
        node.setLeftChild(rightChild);

        int height = Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1;
        node.setHeight(height);
        int height1 = Math.max(height(newRoot.getLeftChild()), height(newRoot.getRightChild())) + 1;
        node.setHeight(height1);


        return newRoot;
    }

    private int getBalance(Node<T> node) {

        if (node == null) {
            return 0;
        }
        return height(node.getLeftChild()) - height(node.getRightChild());
    }

    private int height(Node<T> node) {
        if (node == null) {
            return -1;
        }
        return node.getHeight();
    }

}
