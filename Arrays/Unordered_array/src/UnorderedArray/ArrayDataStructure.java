package UnorderedArray;

/**
 * Created by Abhishek on 1/15/14.
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
    public void 
}
