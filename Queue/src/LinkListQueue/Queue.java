package LinkListQueue;

import LinkList.DoubleEndedLinkList;
import LinkList.Node;

/**
 * Created by stirredo on 2/2/14.
 */

public class Queue {
    DoubleEndedLinkList linkList = new DoubleEndedLinkList();
    public boolean isEmpty() {
        if(linkList.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public void insert(int data) {
        linkList.insertLast(data);
    }
    public Node remove() {
        return linkList.deleteFirst();
    }
    public Node peek() {
        return linkList.peekFirst();
    }
    public void displayQueue() {
        linkList.displayList();
    }
}
