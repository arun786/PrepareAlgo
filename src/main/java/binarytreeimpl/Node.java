package binarytreeimpl;

import lombok.Getter;
import lombok.Setter;

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
                '}';
    }
}
