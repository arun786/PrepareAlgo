package stacks.linkedList;

public class Stack<T extends Comparable<T>> {

    private Node<T> root;
    private int count;

    public void push(T data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            Node<T> oldNode = root;
            root = new Node<>(data);
            root.setNextNode(oldNode);
        }
        ++count;
    }

    public int size() {
        return count;
    }

    public T pop() {
        if (size() > 0) {
            T toPop = root.getData();
            root = root.getNextNode();
            --count;
            return toPop;
        }
        return null;
    }

    public T peek() {
        if (root != null)
            return root.getData();

        return null;
    }
}
