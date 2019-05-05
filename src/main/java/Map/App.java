package Map;

public class App {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.put(1, 12);
        hashTable.put(2, 13);
        hashTable.put(3, 15);

        System.out.println(hashTable);

        int i = hashTable.get(3);
        System.out.println(i);

    }
}
