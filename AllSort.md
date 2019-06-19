# Implementing all sort algorithms




    package sorting;
    
    import java.util.Arrays;
    
    public class AllSort {
    
        static int p[] = {1, 4, 2, 6, 3, 9, 4, 0};
    
        public static void main(String[] args) {
            insertionSort(p);
            System.out.println(Arrays.toString(p));
        }
    
    
        public static void bubbleSort(int[] array) {
            boolean swap = false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - 1 - i; j++) {
                    if (array[j] > array[j + 1])
                        swap(j, j + 1);
    
                }
            }
        }
    
        public static void selectionSort(int[] array) {
            //O(N^2)
            for (int i = 0; i < array.length; i++) {
                int index = i;
                for (int j = i; j < array.length; j++) {
                    if (array[j] < array[index])
                        index = j;
                }
                if (index != i) {
                    swap(index, i);
                }
            }
        }
    
        public static void insertionSort(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                int j = i;
                while (j > 0 && nums[j - 1] < nums[j]) {
                    swap(j - 1, j);
                    --j;
                }
            }
        }
    
        private static void swap(int j, int i) {
            int temp = p[j];
            p[j] = p[i];
            p[i] = temp;
        }
    }
