/**
 * Created by stirredo on 6/21/2014.
 */
public class ArrayClass {
    public int[] array;
    public int size;
    public int count;

    public ArrayClass(int size) {
        this.size = size;
        this.count = 0;
        array = new int[size];

    }

    public boolean insert(int data) {
        if (count == size) {
            return false;
        } else {
            array[count] = data;
            count++;
            return true;
        }
    }

    public int remove(int index) {
        int temp = array[index];
        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
        return temp;
    }

    public void displayArray() {
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }

    protected void swap(int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
