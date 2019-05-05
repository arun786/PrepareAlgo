package algorithms;

public class BinarySearch {

    private int[] arrays;

    public BinarySearch(int[] arrays) {
        this.arrays = arrays;
    }

    public int binarySearch(int item) {
        return binarySearch(0, arrays.length-1, item);
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
