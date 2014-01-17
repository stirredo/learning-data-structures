package BinarySearch;

/**
 * Created by stirredo on 1/17/14.
 */
public class BinarySearchApp {
    public static void main(String[] args) {
        Integer[] array = {1,3,4,5,6,7,8,9,29};
        Integer location = ArrayBinarySearch.find(array,29);
        if(location != null) {
            System.out.println("Found at " + location);
        } else {
            System.out.println("Couldn't find it.");
        }
    }
}
