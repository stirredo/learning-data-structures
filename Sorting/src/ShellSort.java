import jdk.nashorn.tools.Shell;

/**
 * Created by stirredo on 6/21/2014.
 */
public class ShellSort extends ArrayClass {
    public ShellSort(int size) {
        super(size);
    }

    public void sort() {
        /**
         * Algo:
         *  1. Figure out h [ Initial (also notice the initial while loop(h <= count/3)) h = (h * 3) + 1; next h = (h-1)/3 {Inverse of that function} until h >= 1]
         *  2. What you are doing is performing Insertion sort on h-way interval. (read hows it implemented, its a little different)
         *      2a. If initial h = 13 then perform insertion sort on every 13th element.
         *      For ex. It will happen on 0,13,26 and then 1,14,27 and then 2,15,28
         *      2b. Decrement h =  (h-1)/3
         *  3. Hows it implemented:
         *      3a. The outer most while loop is check for when h == 1
         *      3b. The outer for loop is initialized to h and incremented by 1 till its less count (real count in array starts from 0 so its till (count - 1))
         *      3c. The inner loop is initialized to outer and is decremented by h till inner >= h so that inside that
         *      loop when you check for {array[inner - h]} you won't get a NullPointerException
         *  4. Example run for 15 elements:
         *   4a. h is initialized to 13
         *    outer is initialized to 13 and inner is also initialized to 13 (outer)
         *    Now, Inside inner, we check for array[13-h(13)] > 13, when we decrement inner, the loop breaks (inner)
         *    outer is incremented by 1 (outer = 14), inner checks for (1,14)
         *    This happens till  < count (14)
         *   4b. Now h is 4
         *       outer checks for:
         *       (0,4)
         *       (1,5)
         *       (2,6)
         *       (3,7)
         *       (0,4,8) <---- Notice since 0 and 4 are already sorted then that means the whole of 0,4,8 is sorted
         *   Now you will be able to connect what to what the point 2 says.
         */

        int h = 1;

        while (h <= (count / 3)) {
            h = (h * 3) + 1;
        }

        while (h >= 1) {
            for (int outer = h; outer < count; outer++) {
                for (int inner = outer; inner >= h; inner -= h) {
                    if (array[inner - h] > array[inner]) {
                        swap(inner - h, inner);
                    } else {
                        break;
                    }
                }
            }
            h = (h - 1) / 3;
        }




    }

    public static void main(String[] args) {
        int size = 15;
        ShellSort array = new ShellSort(size);
//        for (int i = 0; i < size; i++) {
//            array.insert((int) (Math.random() * 99));
//        }
        array.insert(11);
        array.insert(90);
        array.insert(58);
        array.insert(18);
        array.insert(5);
        array.insert(25);
        array.insert(96);
        array.insert(35);
        array.insert(11);
        array.insert(9);
        array.insert(28);
        array.insert(84);
        array.insert(85);
        array.insert(78);
        array.insert(30);
        array.displayArray();
        array.sort();
        array.displayArray();
    }
}
