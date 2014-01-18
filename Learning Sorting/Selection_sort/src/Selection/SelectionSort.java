package Selection;
import Sort.ArraySort;

/**
 * Created by stirredo on 1/18/14.
 */
public class SelectionSort extends ArraySort {
    @Override
    public void sort() {
        int outer,inner,min;
        for (outer=0;outer<(count-1);outer++) {
            min = outer;
            for (inner=outer+1;inner<count;inner++) {
                //System.out.println(array[inner]+" "+array[outer]+" "+array[min]);
                if(array[inner] < array[min]) {
                    min = inner;
                }
            }
            if(array[min] != array[outer]) {
                swap(outer,min);
            }
        }
    }
    public SelectionSort(int maxsize) {
        super(maxsize);

    }
}
