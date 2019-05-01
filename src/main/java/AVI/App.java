package AVI;

public class App {
    public static void main(String[] args) {

        AVL<Integer> avl = new AVL<>();
        avl.insert(10);
        avl.insert(15);
        System.out.println(avl);
        avl.insert(13);
        System.out.println(avl);


    }
}
