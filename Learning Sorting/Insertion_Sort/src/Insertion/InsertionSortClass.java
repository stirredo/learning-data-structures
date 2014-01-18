package Insertion;
import Sort.ArraySort;
/**
 * Created by stirredo on 1/18/14.
 */
public class InsertionSortClass extends ArraySort {
    public InsertionSortClass(int maxsize) {
        super(maxsize);
    }
    @Override
    public void sort() {
        int inner,outer;

        for (outer=0;outer<count;outer++) {
            for(inner=outer;inner>0;inner--) {
                if(array[inner] < array[inner-1]) {
                    swap(inner,inner-1);
                }
            }
        }
    }
}
