package bst;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Node<T> {

    private T data;
    private Node<T> leftChildNode;
    private Node<T> rightChildNode;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", leftChildNode=" + leftChildNode +
                ", rightChildNode=" + rightChildNode +
                '}';
    }
}


interface Tree<T> {
    void insert(T newData);

    void traverse();

    T getMax();

    T getMin();

    void delete(T data);
}

@ToString
class BST<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;


    @Override
    public void insert(T newData) {

        if (root == null) {
            root = new Node<>(newData);
        } else {
            insertNode(root, newData);
        }
    }

    private void insertNode(Node<T> node, T newData) {
        /**
         * LeftChildNode
         */
        if (newData.compareTo(node.getData()) < 0) {

            if (node.getLeftChildNode() != null) {
                insertNode(node.getLeftChildNode(), newData);

            } else {
                Node<T> newNode = new Node<>(newData);
                node.setLeftChildNode(newNode);
            }

        }

        /**
         * RightChildNode
         */
        if (newData.compareTo(node.getData()) > 0) {
            if (node.getRightChildNode() != null) {
                insertNode(node.getRightChildNode(), newData);
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setRightChildNode(newNode);
            }
        }
    }

    @Override
    public void traverse() {

        if (root == null) {
            System.out.println("No data present");
        }

        inOrderTraversalNode(root);
    }

    @Override
    public T getMax() {
        T max = getMaxNode(root);
        return max;
    }

    @Override
    public T getMin() {
        return getMinNode(root);
    }

    @Override
    public void delete(T data) {
        if (root == null) {
            System.out.println("empty list");
        } else {

            delete(root, data);
        }
    }

    private Node<T> delete(Node<T> node, T data) {


        if (data.compareTo(node.getData()) < 0) {
            //means left child node
            node.setLeftChildNode(delete(node.getLeftChildNode(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            //means right child node
            node.setRightChildNode(delete(node.getRightChildNode(), data));
        } else {
            //means the node is found

            //both the child nodes are empty
            if (node.getLeftChildNode() == null && node.getRightChildNode() == null) {
                System.out.println("deleting the node");
                return null;
            }

            if (node.getLeftChildNode() == null) {
                Node<T> newNode = node.getRightChildNode();
                node = null;
                return newNode;
            }

            if (node.getRightChildNode() == null) {
                Node<T> newNode = node.getLeftChildNode();
                node = null;
                return newNode;
            }

            //here the both the child nodes have values
            //get the predecessor

            Node<T> highest = getPredeccessor(node);
            node.setData(highest.getData());
            node.setLeftChildNode(delete(node.getLeftChildNode(), highest.getData()));
        }

        return node;

    }

    private Node<T> getPredeccessor(Node<T> node) {

        if (node.getRightChildNode() != null) {
            return getPredeccessor(node.getRightChildNode());
        }

        return node;
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

    private void inOrderTraversalNode(Node<T> node) {

        if (node.getLeftChildNode() != null) {
            inOrderTraversalNode(node.getLeftChildNode());
        }

        System.out.print(node + " ");

        if (node.getRightChildNode() != null) {
            inOrderTraversalNode(node.getRightChildNode());
        }
    }
}
