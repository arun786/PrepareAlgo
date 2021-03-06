package LinkedListTut;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int sizeOfList;


    @Override
    public void insert(T data) {
        if (root == null) {
            this.root = new Node<>(data);
        } else {
            insertDataAtBeginning(data);
        }

        ++sizeOfList;
    }

    @Override
    public void insertAtEnd(T data) {
        insertDataAtEnd(data, root);
    }

    /**
     * O(1) complexity
     *
     * @param data
     */
    private void insertDataAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(root);
        this.root = newNode;
    }

    /**
     * O(N) complexity
     *
     * @param data
     * @param node
     */
    private void insertDataAtEnd(T data, Node<T> node) {
        /**
         * this is to iterate through the node, to get to the last node
         * where the next node is null.
         */
        if (node != null && node.getNextNode() != null) {
            insertDataAtEnd(data, node.getNextNode());
        } else {
            /**
             * we reach here when we have iterated the whole list
             * if condition is when we have atleast one node else
             * is when there is no node present
             */
            if (sizeOfList > 0) {
                Node<T> newNode = new Node<>(data);
                root.setNextNode(newNode);
            } else {
                root = new Node<>(data);
            }
        }
        ++sizeOfList;
    }

    @Override
    public void delete(T data) {
        /**
         * if root is null return
         */
        if (root == null) {
            return;
        }

        --sizeOfList;
        /**
         * if there is only root node and data is present in the root node
         */

        if (this.root.getData().compareTo(data) == 0) {
            this.root = this.root.getNextNode();
        } else {
            remove(data, root, root.getNextNode());
        }

    }

    private void remove(T dataToBeDeleted, Node<T> previousNode, Node<T> actualNode) {

        while (actualNode != null) {
            if (actualNode.getData().compareTo(dataToBeDeleted) == 0) {
                previousNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                return;
            }
            previousNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public void traverse() {

        Node<T> node = root;
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNextNode();
        }

        System.out.println();

    }

    @Override
    public int size() {
        return sizeOfList;
    }

    @Override
    public T middle() {
        Node<T> faster = root;
        Node<T> slower = root;

        while (faster != null && faster.getNextNode() != null) {
            faster = faster.getNextNode().getNextNode();
            slower = slower.getNextNode();
        }
        return slower.getData();
    }

    @Override
    public void reverse() {
        Node<T> previous = null;
        Node<T> current = this.root;
        Node<T> next;

        while (current != null) {
            next = current.getNextNode();
            current.setNextNode(previous);
            previous = current;
            current = next;
        }
        this.root = previous;
    }


}
