package binarytreeimpl;

public interface Tree<T> {

    void insertTree(T data);

    T getMax();

    T getMin();

    void traversal();

    void delete(T data);

    Node<T> getRoot();

    Node<T> getKthSmallest(Node<T> node, int k);

    int getAgeSum();

}
