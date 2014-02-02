package LinkListStack;

import LinkList.DoubleEndedLinkList;
import LinkList.Node;
/**
 * Created by stirredo on 2/2/14.
 */

public class Stack {
    DoubleEndedLinkList linkList = new DoubleEndedLinkList();
    public boolean isEmpty() {
        if(linkList.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
    public void push(int data) {
        linkList.insertFirst(data);

    }
    public Node pop() {
        return linkList.deleteFirst();
    }
    public Node peek() {
        return linkList.peekFirst();
    }
    public void displayStack() {
        linkList.displayList();
    }



}
