package stacks.Arrays;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stack<T> {
    private T[] stack;
    private int numberOfItems;

    public Stack() {
        this.stack = (T[]) new Object[1];
    }

    public void push(T newData) {

        if (numberOfItems == this.stack.length) {
            resize(numberOfItems * 2);
        }

        this.stack[numberOfItems++] = newData;
    }

    private void resize(int capacity) {
        T[] newStack = (T[]) new Object[capacity];

        for (int i = 0; i < numberOfItems; i++) {
            newStack[i] = stack[i];
        }

        this.stack = newStack;
    }

    public int size() {
        return numberOfItems;
    }

    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    public T pop() {
        if (numberOfItems > 0) {

            T itemToPop = this.stack[--numberOfItems];

            if (numberOfItems > 0 && numberOfItems == this.stack.length / 4) {
                resize(this.stack.length / 2);
            }
            return itemToPop;
        }
        return null;
    }
}
