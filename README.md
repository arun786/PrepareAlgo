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