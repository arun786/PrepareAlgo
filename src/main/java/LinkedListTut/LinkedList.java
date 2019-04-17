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

    }

    @Override
    public void traverse() {

    }

    @Override
    public int size() {
        return 0;
    }


}
