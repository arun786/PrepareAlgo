package LinkedListTut;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int sizeOfList;


    @Override
    public void insert(T data) {
        if (root == null) {
            ++sizeOfList;
            this.root = new Node<>(data);
        } else {
            insertDataAtBeginning(data);
        }
    }

    private void insertDataAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(root);
        this.root = newNode;
    }
}
