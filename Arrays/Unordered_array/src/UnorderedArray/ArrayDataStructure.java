package UnorderedArray;

/**
 * Created by Stirredo on 1/15/14.
 */
public class ArrayDataStructure {
    private long[] array;
    private int count;
    public ArrayDataStructure(int size) {
        array = new long[size];
        count = 0;
    }
    public int find(long searchKey) {
        //returns the key (0 to n) otherwise returns -1
        int i;
        for(i=0;i < count;i++) {
            if(array[i] == searchKey) {
                return i;

            }

        }
        return -1;
    }
    public void insert(long value) {
        if(count < array.length) {
            array[count] = value;
        }
        count++;
    }
    public boolean delete(long value) {
        int j;
        for(j=0;j<count;j++) {
            if(array[j] == value) {
                break;
            }
        }
        if(j == count ) {
            return false;
        } else {
            for(int i = j;i < count;i++) {
                array[i] = array[i+1];
            }
            count--;
            return true;
        }


    }
    public void display() {
        for(int j=0;i<count;i++) {
            System.out.println(a[j]+ " ");

        }
        System.out.println("");
    }
}
