package Selection;

/**
 * Created by stirredo on 1/18/14.
 */
public class SelectionSortApp {
    public static void main(String[] args) {
        SelectionSort is = new SelectionSort(100);
        is.insert(89);
        is.insert(78);
        is.insert(123);
        is.insert(83);
        is.insert(1);
        is.insert(32);
        is.insert(5);
        is.display();
        is.sort();
        is.display();

    }
}
