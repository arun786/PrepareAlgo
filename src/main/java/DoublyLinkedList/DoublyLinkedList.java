package DoublyLinkedList;

import lombok.ToString;

@ToString
public class DoublyLinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int size;

    @Override
    public void add(T data) {

        if (root == null) {
            root = new Node<T>(data);
        } else {
            Node<T> newNode = new Node<T>(data);
            newNode.setNext(root);
            root.setPrevious(newNode);
            root = newNode;
        }
        ++size;
    }
}
