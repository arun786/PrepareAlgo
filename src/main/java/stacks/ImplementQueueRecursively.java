package stacks;

import java.util.Stack;

public class ImplementQueueRecursively {

    private Stack<Integer> root;

    public ImplementQueueRecursively() {
        root = new Stack<>();
    }


    public void enqueue(int item) {
        root.push(item);
    }

    public int dequeue() {

        Integer item = root.pop();
        if (root.size() == 1) {
            return item;
        }

        int lastItem = dequeue();
        root.push(item);
        return lastItem;
    }

    public static void main(String[] args) {
        ImplementQueueRecursively implementQueueRecursively = new ImplementQueueRecursively();
        implementQueueRecursively.enqueue(10);
        implementQueueRecursively.enqueue(100);
        implementQueueRecursively.enqueue(1000);
        implementQueueRecursively.enqueue(10000);

        System.out.println(implementQueueRecursively.dequeue());
        System.out.println(implementQueueRecursively.dequeue());
        System.out.println(implementQueueRecursively.dequeue());
        System.out.println(implementQueueRecursively.dequeue());
        implementQueueRecursively.enqueue(10200);
        System.out.println(implementQueueRecursively.dequeue());
    }
}
