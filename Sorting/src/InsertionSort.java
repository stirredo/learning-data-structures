/**
 * Created by stirredo on 6/21/2014.
 */
public class InsertionSort extends ArrayClass {
    public InsertionSort(int size) {
        super(size);
    }

    public void sort() {
        int inner, outer;

        for (inner = 0; inner < count; inner++) {
            for (outer = inner; outer > 0; outer--) {
                if (array[outer - 1] > array[outer]) {
                    swap(outer - 1, outer);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        InsertionSort array = new InsertionSort(10);
        for (int i = 0; i < 10; i++) {
            array.insert((int)(Math.random() * 99));
        }
        array.displayArray();
        array.sort();
        array.displayArray();
    }

}
