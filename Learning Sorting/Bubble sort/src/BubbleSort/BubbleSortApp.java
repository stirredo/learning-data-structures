package BubbleSort;

/**
 * Created by stirredo on 1/17/14.
 */
public class BubbleSortApp {
    public static void main(String[] args) {
        ArrayBubbleSort bs = new ArrayBubbleSort(100);
        bs.insert(123);
        bs.insert(12);
        bs.insert(133);
        bs.insert(13);
        bs.insert(723);
        bs.insert(523);
        bs.insert(823);
        bs.insert(213);
        bs.insert(93);
        bs.display();
        bs.bubbleSort();
        bs.display();
    }
}
