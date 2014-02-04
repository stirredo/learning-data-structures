package DoublyDoubleEndedLinkList;

/**
 * Created by stirredo on 2/3/14.
 */
public class DoublyNode<type> {
    type data;
    DoublyNode next;
    DoublyNode prev;
    public DoublyNode(type data) {
        this.data = data;
    }
    public void displayNode() {
        System.out.print(this.data);
    }

}
