package Insertion;

/**
 * Created by stirredo on 1/18/14.
 */
public class InsetionSortApp {
    public static void main(String[] args) {
        InsertionSortClass is = new InsertionSortClass(100);
        is.insert(89);
        is.insert(45);
        is.insert(12);
        is.insert(77);
        is.insert(99);
        is.insert(77);
        is.insert(66);
        System.out.println("Before sorting: ");
        is.display();
        is.sort();
        System.out.println("After sorting");
        is.display();
    }
}
