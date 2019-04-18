package LinkedListTut;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> nextNode;

    public Node(T data) {
        this.data = data;
    }


}
