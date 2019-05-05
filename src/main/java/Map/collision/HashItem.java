package Map.collision;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HashItem {
    private int key;
    private int value;
    private HashItem nextHashItem;

    public HashItem(int key, int value) {
        this.key = key;
        this.value = value;
    }
}


@ToString
class HashTable {
    private static final int SIZE = 10;
    private HashItem[] hashItems = new HashItem[SIZE];

    public int generateIndex(int key) {
        return key % SIZE;
    }


    public void put(int key, int value) {
        int index = generateIndex(key);

        if (hashItems[index] == null) {
            hashItems[index] = new HashItem(key, value);
        } else {
            //collision

            HashItem hashItem = hashItems[index];
            while (hashItem.getNextHashItem() != null) {
                hashItem = hashItem.getNextHashItem();
            }

            hashItem.setNextHashItem(new HashItem(key, value));
        }
    }

    public int get(int key) {
        int index = generateIndex(key);

        if (hashItems[index] == null) {
            return -1;
        }

        HashItem hashItem = hashItems[index];
        if (hashItem != null && hashItem.getKey() != key) {
            hashItem = hashItem.getNextHashItem();
        }

        if (hashItem == null) {
            return -1;
        }

        return hashItem.getValue();

    }
}
