package LinkedListTut;

public interface List<T> {
    void insert(T data);

    void insertAtEnd(T data);

    void delete(T data);

    void traverse();

    int size();

    T middle();

    void reverse();
}
