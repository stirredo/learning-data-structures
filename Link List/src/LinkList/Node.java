package LinkList;

/**
 * Created by stirredo on 1/27/14.
 */
public class Node {
    protected int data;
    protected Node next;
    public Node(int data) {
        this.data = data;

    }
    public void displayLink() {
        System.out.println("This node contains: "+this.data);
    }
}
