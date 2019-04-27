package binarytreeimpl;

public interface Tree<T> {

    void insertTree(T data);

    T getMax();

    T getMin();

    void traversal();
}
