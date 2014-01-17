package OrderedArray;
import UnorderedArray.*;
/**
 * Created by stirredo on 1/15/14.
 */
public class ArrayDataStructure extends UnorderedArray.ArrayDataStructure {
    //find uses binary search
    private long[] array;
    private int count;
    public ArrayDataStructure(int maxsize) {
        super(maxsize);
        array = new long[maxsize];
        count = 0;

    }
    public Integer find(long key) {
        int lowerBound = 0;
        int upperBound = count - 1;
        while(true) {

            int index = (lowerBound + upperBound)/2;
            if(array[index] == key) {
                return index;
            }
            else if (lowerBound > upperBound) {
                return null;

            } else {
                if(key > array[index]) {
                    lowerBound = index + 1;

                } else {
                    upperBound = index - 1;

                }
            }
        }
    }
    public void insert(long value) {
        int i,j;
        for(i=0;i<count;i++) {
           if(array[i] > value) {
                break;
            }
        }
        for(j=count;j>i;j--) {
            array[j] = array[j-1];
        }
        array[i] = value;
        count++;
    }
    public void display() {
        for(int i=0;i<count;i++) {
            System.out.print(array[i] + " ");

        }
        System.out.println("");
    }
}
