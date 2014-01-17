package Sort;

import java.lang.Integer;

/**
 * Created by stirredo on 1/17/14.
 */
public abstract class ArraySort {
    public Integer[] array;
    public int count;
    public ArraySort(int maxsize) {
        array = new Integer[maxsize];
        count = 0;
    }
    public abstract void sort();
    public void display() {
        for (int i=0;i< count;i++) {
            System.out.print(array[i] + " ");

        }
        System.out.println("");
    }
    public void insert(Integer value) {
        array[count] = value;
        count++;
    }
    public Integer find(Integer key) { //uses binary search
        int lowerBound = 0;
        int upperBound = 0;
        while(true) {
            int index =  (lowerBound + upperBound)/ 2;
            if(array[index]== key) {
                return index;
            } else if (lowerBound > upperBound) {
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
    public void delete(int index) {
        for (int i=index;i < count;i++) {
            array[i] = array[i+1];

        }
    }
    public void swap(int indexOne,int indexTwo) {
        Integer temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    public static void main(String[] args) {

    }
}
