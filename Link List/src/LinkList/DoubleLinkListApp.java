package LinkList;

/**
 * Created by stirredo on 2/2/14.
 */
public class DoubleLinkListApp {
    public static void main(String[] args) {
        DoubleEndedLinkList doubleEndedLinkList = new DoubleEndedLinkList();
        doubleEndedLinkList.insertLast(10);
        doubleEndedLinkList.insertLast(20);
        doubleEndedLinkList.insertLast(30);
        doubleEndedLinkList.deleteFirst();
        doubleEndedLinkList.insertFirst(50);
        doubleEndedLinkList.deleteLast();
        doubleEndedLinkList.displayList();
    }

}
