package queue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T extends Comparable<T>> {

    private T data;
    private Node<T> nextNode;

    public Node(T data) {
        this.data = data;
    }
}
