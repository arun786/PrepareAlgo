package AVI;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Node<T extends Comparable<T>> {

    private T data;
    private Node<T> leftChild;
    private Node<T> rightChild;
    private int height;

    public Node(T data) {
        this.data = data;
    }
}
