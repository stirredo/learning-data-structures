package DoublyDoubleEndedLinkList;

/**
 * Created by stirredo on 2/3/14.
 */
public class DoublyNode<type> {
    public type data;
    public DoublyNode next;
    public DoublyNode prev;
    public DoublyNode(type data) {
        this.data = data;
    }
    public void displayNode() {
        System.out.print(this.data);
    }
    public type getData() {
        return data;
    }

}
