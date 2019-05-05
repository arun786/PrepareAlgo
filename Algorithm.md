# GCD

    package recursion;
    
    public class gcd {
        public static void main(String[] args) {
    
            gcd gcd = new gcd();
            int gcd1 = gcd.gcd(10, 15);
            System.out.println(gcd1);
            int gcd2 = gcd.gcd(15, 10);
            System.out.println(gcd2);
    
            int gcdRecursive = gcd.gcdRecursive(10, 15);
            System.out.println(gcdRecursive);
    
        }
    
        private int gcd(int n1, int n2) {
            while (n2 != 0) {
                int temp = n2;
                n2 = n1 % n2;
                n1 = temp;
            }
            return n1;
        }
    
        private int gcdRecursive(int n1, int n2) {
            if (n2 == 0) return n1;
    
            return gcdRecursive(n2, n1 % n2);
        }
    }


# Binary Search

    package algorithms;
    
    public class BinarySearch {
    
        private int[] arrays;
    
        public BinarySearch(int[] arrays) {
            this.arrays = arrays;
        }
    
        public int binarySearch(int item) {
            return binarySearch(0, arrays.length, item);
        }
    
        private int binarySearch(int startIndex, int endIndex, int item) {
            if (startIndex > endIndex) {
                System.out.println("Item not found");
                return -1;
            }
    
            int middleIndex = (startIndex + endIndex) / 2;
    
            if (item == arrays[middleIndex]) {
                return middleIndex;
            } else if (item > arrays[middleIndex]) {
                return binarySearch(middleIndex + 1, endIndex, item);
            } else {
                return binarySearch(startIndex, middleIndex - 1, item);
            }
    
        }
    
        public static void main(String[] args) {
            int[] arrays = {1, 3, 5, 7, 9, 10};
            BinarySearch binarySearch = new BinarySearch(arrays);
            int i = binarySearch.binarySearch(9);
            System.out.println(i);
        }
    }
