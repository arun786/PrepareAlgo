package stacks;


import java.util.Stack;

public class ImplementQueueWithStack {

    public static void main(String[] args) {

        QueueStack queueStack = new QueueStack();
        queueStack.enqueue(10);
        queueStack.enqueue(100);
        queueStack.enqueue(1000);
        queueStack.enqueue(10000);
        queueStack.enqueue(100000);

        System.out.println(queueStack.dequeue());
        System.out.println(queueStack.dequeue());
        System.out.println(queueStack.dequeue());
        System.out.println(queueStack.dequeue());

        queueStack.enqueue(23);
        System.out.println(queueStack.dequeue());
        System.out.println(queueStack.dequeue());

    }
}


class QueueStack {
    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public QueueStack() {
        this.enqueueStack = new Stack<>();
        this.dequeueStack = new Stack<>();
    }

    public void enqueue(int item) {
        enqueueStack.push(item);
    }

    public int dequeue() {
        if (enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
            throw new RuntimeException("Enqueue Stack is Empty");
        }

        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

        return dequeueStack.pop();
    }
}
