import java.lang.Comparable;
/**
 * Created by stirredo on 6/16/2014.
 */
public class LinearProbing {
    private static class DataItem<keyType extends Comparable<keyType>,valueType> implements Comparable<keyType> {

        public keyType key;
        public valueType value;
        public boolean deleted; // True if the key item has been deleted.
        public DataItem(keyType key, valueType value) {
            this.value = value;
            this.key = key;
            deleted = false;
        }

        @Override
        public int compareTo(keyType o) {
            return key.compareTo(o);

        }
    }

    private static class HashTable<keyType extends Comparable<keyType>, valueType> {
        private DataItem<keyType, valueType> array[];
        private int arraySize;

        public HashTable(int size) {
            arraySize = size;
            array = (DataItem<keyType, valueType>[]) new DataItem[2 * (int)size]; //Take the array of twice the size of number of elements

        }

        private int hashFunction(keyType key) {
            return key.hashCode() % arraySize;
        }

        public void put(keyType key, valueType value) {
            int hash = hashFunction(key);
            while (array[hash] != null && !array[hash].deleted) {
                hash++;
                hash = hash % arraySize;
            }
            array[hash] = new DataItem<keyType, valueType>(key, value);
        }

        public valueType get(keyType key) {
            int hash = hashFunction(key);
            while ( array[hash] != null && !array[hash].deleted) {
                if (array[hash].key.compareTo(key) == 0) {
                    return array[hash].value;
                } else {
                    hash++;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        HashTable<String, Integer> ht = new HashTable<String, Integer>(10);
        ht.put("Stirredo", 25);
        ht.put("RandomName1", 23);
        ht.put("RandomName2", 27);
        Integer answer;
        if ((answer = ht.get("Stirredo")) != null) {
            System.out.println(answer);
        }
        if ((answer = ht.get("stirredo")) != null) {
            System.out.println(answer);
        } else {
            System.out.println("Not found");
        }

    }
}
