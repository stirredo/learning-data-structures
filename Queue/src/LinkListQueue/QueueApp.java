package LinkListQueue;
import LinkList.Node;
/**
 * Created by stirredo on 2/2/14.
 */
public class QueueApp {

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);
        while(!queue.isEmpty()) {
            Node temp = queue.remove();
            temp.displayNode();
            System.out.print(" ");
        }

    }
}
