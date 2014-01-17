package BubbleSort;

/**
 * Created by stirredo on 1/16/14.
 */
public class ArrayBubbleSort {
    private Integer[] array;
    private int count;
    public ArrayBubbleSort(int maxSize) {
        array = new Integer[maxSize];
        count = 0;
    }
    public void insert(Integer value) {
        array[count] = value;
        count++;
    }
    public void display() {
        for (int i=0;i<count;i++) {
            System.out.println("arr[" + i + "]" + array[i]+" ");

        }
        System.out.println("");
    }
    public void swap(Integer indexOne,Integer indexTwo) {
        Integer temp;
        temp = array[indexTwo];
        array[indexTwo] = array[indexOne];
        array[indexOne] = temp;


    }
    public void bubbleSort() {
        for(int i=(count-1);i>1;i--) {
            for(int j=0;j<i;j++) {
                if(array[j] > array[j+1]) {
                    swap(j,j+1);
                }
            }
        }
    }


}



