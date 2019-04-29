# PrepareAlgo


## To find duplicates in an array, where the values in the array are less than the length of the array

    public List<Integer> findDuplicatesWhenValueIsLessThanSizeOfArray(List<Integer> numbers) {
    
            /**
             *         Iterate the List
             *         Get the value of at index.
             *         get the absolute value of that index.
             *         go to index of that value.
             *         check the sign of the value at that valued index.
             *         If it is positive, change the sign to negative
             *         if it is negative the indexed value has been repeated
             */
    
            List<Integer> duplicates = new ArrayList<>();
    
            for (int i = 0; i < numbers.size(); i++) {
                Integer valueAtThatIndex = numbers.get(i);
                int abs = Math.abs(valueAtThatIndex);
                Integer value = numbers.get(abs);
                if (value > 0) {
                    numbers.set(abs, -value);
                } else {
                    duplicates.add(abs);
                }
            }
    
            return duplicates;
            
        } 


## Implementation of linked list

    @Getter
    @Setter
    @ToString
    public class Node<T extends Comparable<T>> {
        private T data;
        private Node<T> nextNode;
    
        public Node(T data) {
            this.data = data;
        }
    }



    public interface List<T> {
        void insert(T data);
    
        void insertAtEnd(T data);
    
        void delete(T data);
    
        void traverse();
    
        int size();
    }


    @Getter
    @Setter
    @ToString
    public class LinkedList<T extends Comparable<T>> implements List<T> {
    
        private Node<T> root;
        private int sizeOfList;
    
    
        @Override
        public void insert(T data) {
            if (root == null) {
                this.root = new Node<>(data);
            } else {
                insertDataAtBeginning(data);
            }
    
            ++sizeOfList;
        }
    
        @Override
        public void insertAtEnd(T data) {
            insertDataAtEnd(data, root);
        }
    
        /**
         * O(1) complexity
         *
         * @param data
         */
        private void insertDataAtBeginning(T data) {
            Node<T> newNode = new Node<>(data);
            newNode.setNextNode(root);
            this.root = newNode;
        }
    
        /**
         * O(N) complexity
         *
         * @param data
         * @param node
         */
        private void insertDataAtEnd(T data, Node<T> node) {
            /**
             * this is to iterate through the node, to get to the last node
             * where the next node is null.
             */
            if (node != null && node.getNextNode() != null) {
                insertDataAtEnd(data, node.getNextNode());
            } else {
                /**
                 * we reach here when we have iterated the whole list
                 * if condition is when we have atleast one node else
                 * is when there is no node present
                 */
                if (sizeOfList > 0) {
                    Node<T> newNode = new Node<>(data);
                    root.setNextNode(newNode);
                } else {
                    root = new Node<>(data);
                }
            }
            ++sizeOfList;
        }
    
        @Override
        public void delete(T data) {
    
        }
    
        @Override
        public void traverse() {
    
        }
    
        @Override
        public int size() {
            return 0;
        }
    }


## Remove

    @Override
        public void delete(T data) {
            /**
             * if root is null return
             */
            if (root == null) {
                return;
            }
    
            --sizeOfList;
            /**
             * if there is only root node and data is present in the root node
             */
    
            if (this.root.getData().compareTo(data) == 0) {
                this.root = this.root.getNextNode();
            } else {
                remove(data, root, root.getNextNode());
            }
    
        }
    
        private void remove(T dataToBeDeleted, Node<T> previousNode, Node<T> actualNode) {
    
            while (actualNode != null) {
                if (actualNode.getData().compareTo(dataToBeDeleted) == 0) {
                    assert previousNode != null;
                    previousNode.setNextNode(actualNode.getNextNode());
                    actualNode = null;
                    return;
                }
                previousNode = actualNode;
                actualNode = actualNode.getNextNode();
            }
        }
 
 
# Middle

        @Override
        public T middle() {
            Node<T> faster = root;
            Node<T> slower = root;
        
            while (faster != null && faster.getNextNode() != null) {
                faster = faster.getNextNode().getNextNode();
                slower = slower.getNextNode();
            }
            return slower.getData();
        }
        

# reverse

     @Override
        public void reverse() {
            Node<T> previous = null;
            Node<T> current = this.root;
            Node<T> next;
    
            while (current != null) {
                next = current.getNextNode();
                current.setNextNode(previous);
                previous = current;
                current = next;
            }
            this.root = previous;
        }
        
# Stack

## using linked List

    package stacks.linkedList;
    
    public class Stack<T extends Comparable<T>> {
    
        private Node<T> root;
        private int count;
    
        public void push(T data) {
            if (root == null) {
                root = new Node<>(data);
            } else {
                Node<T> oldNode = root;
                root = new Node<>(data);
                root.setNextNode(oldNode);
            }
            ++count;
        }
    
        public int size() {
            return count;
        }
    
        public T pop() {
            if (size() > 0) {
                T toPop = root.getData();
                root = root.getNextNode();
                --count;
                return toPop;
            }
            return null;
        }
    
        public T peek() {
            if (root != null)
                return root.getData();
    
            return null;
        }
    }


## using ArrayList

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
                this.stack[numberOfItems] = null; //for garbage collection
                if (numberOfItems > 0 && numberOfItems == this.stack.length / 4) {
                    resize(this.stack.length / 2);
                }
                return itemToPop;
            }
            return null;
        }
    }

# To find the max value in a stack

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
    

# Implement Queue with the help of Stack

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


# Implementation of Queue Recursively

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


# Binary Search Tree

    package binarytreeimpl;
    
    import lombok.Getter;
    import lombok.Setter;
    
    @Getter
    @Setter
    public class Node<T> {
        private T data;
        private Node<T> leftChildNode;
        private Node<T> rightChildNode;
    
        public Node(T data) {
            this.data = data;
        }
    
        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }



    package binarytreeimpl;
    
    public interface Tree<T> {
    
        void insertTree(T data);
    
        T getMax();
    
        T getMin();
    
        void traversal();
    }


## insert Node

        private Node<T> root;
        
        
        @Override
        public void insertTree(T data) {
        
            if (root == null) {
                root = new Node<>(data);
            } else {
                insertNodeAt(data, root);
            }
        }

        
        private void insertNodeAt(T data, Node<T> node) {
        
            //check the data is greater than node's data , the data will be stored on the right side else on the left side
        
            if (data.compareTo(node.getData()) > 0) {
                //this means it will go to the right side
                if (node.getRightChildNode() != null) {
                    insertNodeAt(data, node.getRightChildNode());
                } else {
                    Node<T> newNode = new Node<>(data);
                    node.setRightChildNode(newNode);
                }
            } else {
                if (node.getLeftChildNode() != null) {
                    insertNodeAt(data, node.getLeftChildNode());
                } else {
                    Node<T> newNode = new Node<>(data);
                    node.setLeftChildNode(newNode);
                }
            }
        }    
        
        
## Get Max

        @Override
        public T getMax() {
        
            T max = null;
            if (root == null) {
                System.out.println("No data present");
            } else {
                max = getMaxNode(root);
            }
        
            return max;
        }
        
        
        private T getMaxNode(Node<T> node) {
            if (node.getRightChildNode() != null) {
                return getMaxNode(node.getRightChildNode());
            }
        
            return node.getData();
        }
        

## Get Min Node

        @Override
        public T getMin() {
        
            T min = null;
            if (root == null) {
                System.out.println("No data ");
            } else {
                min = getMinNode(root);
            }
            return min;
        }
        
        
        private T getMinNode(Node<T> node) {
        
            if (node.getLeftChildNode() != null) {
                return getMinNode(node.getLeftChildNode());
            }
        
            return node.getData();
        }
        
 ## Inorder Traversal
 
 
       @Override
        public void traversal() {
    
            inorderTraversalNode(root);
        }
    
        public void inorderTraversalNode(Node<T> node) {
    
            if (node.getLeftChildNode() != null) {
                inorderTraversalNode(node.getLeftChildNode());
            }
    
            System.out.print(node + " ");
    
            if (node.getRightChildNode() != null) {
                inorderTraversalNode(node.getRightChildNode());
            }
        }
        
## Delete

        @Override
        public void delete(T data) {
            Node<T> tNode = deleteNode(data, root);
        }
        
        private Node<T> deleteNode(T data, Node<T> node) {
        
            if (node == null) return null;
        
            //data to be deleted is on the left child node
            if (data.compareTo(node.getData()) < 0) {
                node.setLeftChildNode(deleteNode(data, node.getLeftChildNode()));
            } else if (data.compareTo(node.getData()) > 0) {
                //data to be deleted is on the right child node
                node.setRightChildNode(deleteNode(data, node.getRightChildNode()));
            } else {
                //we got the node to be deleted
        
                // there can be four conditions
        
                //1. its a leaf node, which means no child node
                if (node.getLeftChildNode() == null && node.getRightChildNode() == null) {
                    System.out.println("Deleting the leaf node" + node);
                    return null;
                } else if (node.getLeftChildNode() == null) {
                    //2. one of the child is present, in this case we have the right child
                    Node<T> tempNode = node.getRightChildNode();
                    node = null;
                    return tempNode;
                } else if (node.getRightChildNode() == null) {
                    //3. one of the child is present, in this case we have the left child
                    Node<T> tempNode = node.getLeftChildNode();
                    node = null;
                    return tempNode;
                }
                //4. both the right node and left node has values
                //we need to find the predecessor
                System.out.println();
                System.out.println("Remove item from node which has got both child node...");
                Node<T> tempNode = getPredecessor(node.getLeftChildNode());
                node.setData(tempNode.getData());
        
                node.setLeftChildNode(deleteNode(tempNode.getData(), node.getLeftChildNode()));
        
            }
        
        
            return node;
        }
        
        private Node<T> getPredecessor(Node<T> node) {
        
            if (node.getRightChildNode() != null) {
                return getPredecessor(node.getRightChildNode());
            }
        
            return node;
        }
        
        
## Compare two Binary trees

    package binarytreeimpl;
    
    public class HelperBinary<T extends Comparable<T>> {
    
        public boolean compare(Node<T> node1, Node<T> node2) {
            if (node1 == null || node2 == null) return node1 == node2;
    
            if (node1.getData().compareTo(node2.getData()) != 0) return false;
    
            return compare(node1.getLeftChildNode(), node2.getLeftChildNode()) && compare(node1.getRightChildNode(), node2.getRightChildNode());
        }
    }

## Kth element of a Binary tree

    @Override
    public Node<T> getKthSmallest(Node<T> node, int k) {
    
        int n = getTreeSize(node.getLeftChildNode()) + 1;
    
        if (n == k) return node;
    
        if (n > k) return getKthSmallest(node.getLeftChildNode(), k);
        return getKthSmallest(node.getRightChildNode(), k - n);
    }
    
    private int getTreeSize(Node<T> node) {
        if (node == null) return 0;
    
        int leftTreeSize = getTreeSize(node.getLeftChildNode());
        int rightTreeSize = getTreeSize(node.getRightChildNode());
    
        return leftTreeSize + rightTreeSize + 1;
    
    }