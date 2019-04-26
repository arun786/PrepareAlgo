package queue;

public class Queue<T extends Comparable<T>> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int count;

    public boolean isEmpty() {
        return count == 0;
    }

    public int count() {
        return count;
    }

    //o(1) - inserting data at the end
    public T enqueue(T data) {


        Node<T> oldLastNode = this.lastNode;
        lastNode = new Node<>(data);
        lastNode.setNextNode(null);

        if (isEmpty()) {
            this.firstNode = lastNode;
        } else {
            oldLastNode.setNextNode(lastNode);
        }
        count++;
        return lastNode.getData();
    }

    public T dequeue() {

        if (lastNode != null)
            count--;
        if (firstNode != null) {
            T dataToBeDequeued = firstNode.getData();
            firstNode = firstNode.getNextNode();

            if (isEmpty()) {
                lastNode = null;
            }
            return dataToBeDequeued;
        }
        return null;


    }
}
