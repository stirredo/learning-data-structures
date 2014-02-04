package DoublyDoubleEndedLinkList;

import LinkList.DoubleEndedLinkList;

/**
 * Created by stirredo on 2/4/14.
 */
public class DoubleEndedLinkListApp {
    public static void main(String[] args) {
        DoubleEndedLinkList linkList = new DoubleEndedLinkList();
        linkList.insertFirst(10);
        linkList.insertFirst(20);
        linkList.deleteFirst();
        linkList.insertLast(30);
        linkList.insertLast(40);
        linkList.deleteLast();
        linkList.displayList();

    }
}
