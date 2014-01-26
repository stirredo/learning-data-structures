package GenericArrayQueue;

/**
 * Created by stirredo on 1/25/14.
 */
public class PriorityQueue  {
    protected int count;
    protected int maxSize;
    protected int[] array;
    public PriorityQueue(int maxSize) {
        this.count = 0;
        this.maxSize = maxSize;
        this.array = new int[maxSize];
    }
    public boolean insert(int value) {
        if(!isFull()) {
            if(isEmpty()) {
                array[count] = value;
                count++;
            } else {
                int i;
                for (i = (count - 1); i >= 0; i--) {
                    if(value > array[i]) {
                        array[i+1] = array[i];

                    } else {
                        break;
                    }
                }
                array[i+1] = value;
                count++;

            }

            return true;

        } else {
            System.out.println("Queue full; couldn't insert.");
            return false;
        }
    }
    public int delete() {
        int temp = array[count - 1];
        count--;
        return temp;
    }

    public boolean isFull() {
        if(count == maxSize) {
            return true;
        } else {
            return false;

        }
    }
    public boolean isEmpty() {
        if(count == 0) {
            return true;
        }
        return false;
    }
}
