import java.lang.reflect.Array;

/**
 * Created by stirredo on 6/23/2014.
 */
public class QuickSort extends ArrayClass {
    public QuickSort(int size) {
        super(size);
    }

    public int partition(int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int i, j;
        i = startIndex;
        j = endIndex + 1;
        while (true) {
            while (array[++i] < pivot) {
                if (i == endIndex) {
                    break;
                }
            }

            while(array[--j] > pivot) {
                if (j == startIndex) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(i, j);
        }
        swap(startIndex, j);
         return j;
    }

    public void sort() {
        sort(0, count - 1);
    }

    private void sort(int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }
        int pivot = partition(startIndex, endIndex);
        sort(startIndex, pivot - 1);
        sort(pivot + 1, endIndex);
    }

    public static void main(String[] args) {
        int size = 15;
        QuickSort array = new QuickSort(size);
        for (int i = 0; i < size; i++) {
            array.insert((int) (Math.random() * 99));
        }
        array.displayArray();
        array.sort();
        array.displayArray();
    }
}
