package stacks.MaxValueStack;

import java.util.Stack;

public class MaxValueInStack {


    public static void main(String[] args) {
        StackMax stackMax = new StackMax();
        stackMax.push(10);
        stackMax.push(100);
        stackMax.push(20);
        stackMax.push(40);

        Integer max = stackMax.getMax();
        System.out.println(max);

    }


}


class StackMax {
    private Stack<Integer> mainStack;
    private Stack<Integer> maxStack;

    public StackMax() {
        mainStack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int data) {
        mainStack.push(data);

        if (mainStack.size() == 1) {
            maxStack.push(data);
        } else {
            if (data > maxStack.peek()) {
                maxStack.push(data);
            } else {
                maxStack.push(maxStack.peek());
            }
        }
    }

    public Integer getMax() {
        return maxStack.peek();
    }
}