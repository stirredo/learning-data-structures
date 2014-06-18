import java.util.LinkedList;

/**
 * Created by stirredo on 6/18/2014.
 */
public class SeparateChaining {
    private static class DataItem<keyType extends Comparable<keyType>, valueType> implements Comparable<keyType> {
        keyType key;
        valueType value;

        public DataItem(keyType key, valueType value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public int compareTo(keyType o) {
            return key.compareTo(o);
        }
    }

    private static class HashTable<keyType extends Comparable<keyType>, valueType> {
        LinkedList<DataItem<keyType, valueType>>[] listArray;
        int arraySize;

        public HashTable(int arraySize) {
            this.arraySize = arraySize;
            listArray = (LinkedList<DataItem<keyType,valueType>>[]) new LinkedList[arraySize];
            for (int i = 0; i < arraySize; i++) {
                listArray[i] = new LinkedList<DataItem<keyType, valueType>>();

            }

        }

        public int hashFunction(keyType key) {
           return key.hashCode() % arraySize;
        }

        public void put(keyType key, valueType value) {
            int hash = hashFunction(key);
            DataItem<keyType, valueType> temp = new DataItem<keyType, valueType>(key, value);
            if (listArray[hash] != null) {
                for (DataItem<keyType, valueType> dt : listArray[hash]) {
                    if (dt.key.compareTo(key) == 0) {
                        dt.value = value;
                        return;
                    }
                }


            }

            listArray[hash].add(temp);

        }

        public valueType get(keyType key) {
            int hash = hashFunction(key);
            for (DataItem<keyType, valueType> temp : listArray[hash]) {
                if (temp.key.compareTo(key) == 0) {
                    return temp.value;
                }
            }
            return null;
        }

        public void delete(keyType key) {
            int hash = hashFunction(key);
            int index = -1;
            for (DataItem<keyType, valueType> temp : listArray[hash]) {
                if (temp.key.compareTo(key) == 0) {
                    index = listArray[hash].indexOf(temp);
                    break;
                }
            }
            if (index != -1) {
                listArray[hash].remove(index);
            } else {
                System.out.println("Item not found; can't be deleted.");
            }
        }



    }

    public static void main(String[] args) {
        HashTable<String, Integer> ht = new HashTable<String, Integer>(10);
        ht.put("Stirredo", 35);
        ht.put("Stirredo", 25);
        System.out.println(ht.get("Stirredo"));
        ht.delete("Stirredo");
        Integer answer;
        if ((answer = ht.get("Stirredo")) != null) {
            System.out.println(answer);
        } else {
            System.out.println("Not found");

        }
    }

}
