package queue;

public class App {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        Integer enqueue = queue.enqueue(10);
        Integer enqueue1 = queue.enqueue(100);
        Integer enqueue2 = queue.enqueue(107);
        System.out.println(enqueue);
        System.out.println(enqueue1);
        System.out.println(enqueue2);

        System.out.println(queue.count());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.count());
    }
}
