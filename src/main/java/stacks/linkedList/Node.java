package stacks.linkedList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T extends Comparable<T>> {
    private Node<T> nextNode;
    private T data;

    public Node(T data) {
        this.data = data;
    }
}
