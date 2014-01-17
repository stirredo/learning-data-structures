package BinarySearch;

/**
 * Created by stirredo on 1/17/14.
 * To improve: Implement better class structure and hence provide better interface to use this method/class
 */
public class ArrayBinarySearch {
    private static int lowerBound,upperBound,key;
    private int[] array;
    public static Integer find(Integer[] array,Integer key) {
        int lowerBound = 0;
        int upperBound = array.length;


        while(true){
            int index = (lowerBound + upperBound)/2;
            if(array[index] == key) {
                return index;
            } else if(lowerBound > upperBound) {
                return null;
            } else {
                if(key < array[index]) {
                    upperBound = index - 1;
                } else {
                    lowerBound = index + 1;
                }
            }

        }
    }

}
