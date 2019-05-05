package Map.probing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class HashItem {
    private int key;
    private int value;
}

@ToString
class HashMap {

    private HashItem[] hashItems;

    public HashMap() {
        hashItems = new HashItem[Constants.SIZE];
    }


    public void put(int key, int value) {

        int index = hashFunction(key);

        if (hashItems[index] == null) {
            String format = String.format("Inserted the value %d at the index %d and key as %d", value, index, key);
            System.out.println(format);
            hashItems[index] = new HashItem(key, value);
        } else {
            //here we have collision
            //logic is if the index is already occupied, go for the next index
            System.out.println("Entering when there is a collision");
            while (hashItems[index] != null) {
                index = (index + 1) % Constants.SIZE;
                System.out.println("Index = " + index);
            }

            String format = String.format("Inserted the value %d at the index %d and key as %d", value, index, key);
            System.out.println(format);
            hashItems[index] = new HashItem(key, value);
        }
    }


    public int get(int key) {

        int index = hashFunction(key);

        while (hashItems[index] != null && hashItems[index].getKey() != key) {
            String format = String.format("Index %d generated for the key %d ", index, key);
            System.out.println(format);
            index = (index + 1) % Constants.SIZE;
        }

        if (hashItems[index] == null) {
            return -1;
        }

        return hashItems[index].getValue();

    }

    private int hashFunction(int key) {
        return key % Constants.SIZE;
    }
}
