/**
 * Created by stirredo on 6/17/2014.
 */
public class DoubleHashing {
    private static class DataItem<keyType extends Comparable<keyType>, valueType> implements Comparable<keyType>{
        public keyType key;
        public valueType value;
        public boolean deleted;
        public DataItem(keyType key, valueType value) {
            this.key = key;
            this.value = value;
            this.deleted = false;

        }
        @Override
        public int compareTo(keyType o) {
            return key.compareTo(o);
        }

    }

    private static class HashTable<keyType extends Comparable<keyType>, valueType> {
        DataItem<keyType, valueType>[] array;
        int arraySize;

        public HashTable(int arraySize) {
            this.arraySize = getGreaterPrime(arraySize);
            array = (DataItem<keyType, valueType>[]) new DataItem[this.arraySize];

        }

        public int hashFunction(keyType key) {
            return key.hashCode() % arraySize;
        }

        public int stepSize(keyType key) {
            int constant = getSmallerPrime(arraySize);
            return constant - (key.hashCode() % constant);

        }

        public boolean isPrime(int num) {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }

            }
            return true;
        }

        public int getGreaterPrime(int num) {
            int i;
            for (i = num; true; i++) {
                if (isPrime(i)) {
                    break;
                }

            }
            return i;
        }

        public int getSmallerPrime(int num) {
            int i;
            for (i = num - 1; i > 2; i--) {
                if (isPrime(num)) {
                    break;
                }
            }
            return i;
        }

        public void put(keyType key, valueType value) {
            int hash = hashFunction(key);
            int step = stepSize(key);
            while (array[hash] != null && !array[hash].deleted) {
                if (array[hash].key.compareTo(key) == 0) {
                    array[hash].value = value;
                    return;
                }
                hash += step;
                hash %= arraySize;
            }
            array[hash] = new DataItem<keyType, valueType>(key, value);
        }

        public valueType get(keyType key) {
            int hash = hashFunction(key);
            int step = stepSize(key);
            while (array[hash] != null && !array[hash].deleted) {
                if (array[hash].key.compareTo(key) == 0) {
                    return array[hash].value;
                }
                hash += step;
                hash %= arraySize;
            }
            return null;
        }

    }

    public static void main(String[] args) {
        HashTable<String, Integer> ht = new HashTable<String, Integer>(30);
        ht.put("Stirredo", 25);
        ht.put("Stirredo", 22);
        Integer answer;
        if ((answer = ht.get("Stirredo")) != null) {
            System.out.println(answer);
        } else {
            System.out.println("Not found");
        }

    }

}

