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

    @Override
    public void delete(T data) {
        Node<T> tNode = deleteNode(data, root);
    }

    @Override
    public Node<T> getRoot() {
        return this.root;
    }

    @Override
    public Node<T> getKthSmallest(Node<T> node, int k) {

        int n = getTreeSize(node.getLeftChildNode()) + 1;

        if (n == k) return node;

        if (n > k) return getKthSmallest(node.getLeftChildNode(), k);
        return getKthSmallest(node.getRightChildNode(), k - n);
    }

    private int getTreeSize(Node<T> node) {
        if (node == null) return 0;

        int leftTreeSize = getTreeSize(node.getLeftChildNode());
        int rightTreeSize = getTreeSize(node.getRightChildNode());

        return leftTreeSize + rightTreeSize + 1;

    }

    private Node<T> deleteNode(T data, Node<T> node) {

        if (node == null) return null;

        //data to be deleted is on the left child node
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChildNode(deleteNode(data, node.getLeftChildNode()));
        } else if (data.compareTo(node.getData()) > 0) {
            //data to be deleted is on the right child node
            node.setRightChildNode(deleteNode(data, node.getRightChildNode()));
        } else {
            //we got the node to be deleted

            // there can be four conditions

            //1. its a leaf node, which means no child node
            if (node.getLeftChildNode() == null && node.getRightChildNode() == null) {
                System.out.println("Deleting the leaf node" + node);
                return null;
            } else if (node.getLeftChildNode() == null) {
                //2. one of the child is present, in this case we have the right child
                Node<T> tempNode = node.getRightChildNode();
                node = null;
                return tempNode;
            } else if (node.getRightChildNode() == null) {
                //3. one of the child is present, in this case we have the left child
                Node<T> tempNode = node.getLeftChildNode();
                node = null;
                return tempNode;
            }
            //4. both the right node and left node has values
            //we need to find the predecessor
            System.out.println();
            System.out.println("Remove item from node which has got both child node...");
            Node<T> tempNode = getPredecessor(node.getLeftChildNode());
            node.setData(tempNode.getData());

            node.setLeftChildNode(deleteNode(tempNode.getData(), node.getLeftChildNode()));

        }


        return node;
    }

    private Node<T> getPredecessor(Node<T> node) {

        if (node.getRightChildNode() != null) {
            return getPredecessor(node.getRightChildNode());
        }

        return node;
    }

    @Override
    public int getAgeSum() {
        return getAgeSum(root);
    }

    private int getAgeSum(Node<T> node) {
        System.out.println("Considering Node : " + node);

        int sum = 0;
        int leftSum = 0;
        int rightSum = 0;


        if (node == null) {
            return 0;
        }

        leftSum = getAgeSum(node.getLeftChildNode());
        rightSum = getAgeSum(node.getRightChildNode());

        String format = String.format("Adding the sum for Node %s, leftsum %d, rightSum %d", node, leftSum, rightSum);
        System.out.println(format);
        sum = ((Person) node.getData()).getAge() + leftSum + rightSum;

        return sum;
    }
}
