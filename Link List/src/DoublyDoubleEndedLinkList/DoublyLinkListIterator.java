package DoublyDoubleEndedLinkList;

import LinkList.DoubleEndedLinkList;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by stirredo on 2/5/14.
 */
public class DoublyLinkListIterator<type> implements Iterator<type> {

    private DoublyNode<type> current;
    private DoublyDoubleEndedLinkList<type> linkList;
    public DoublyLinkListIterator(DoublyDoubleEndedLinkList<type> linkList) {
        this.linkList = linkList;
    }



    @Override
    public boolean hasNext() {
        if(linkList.isEmpty() || linkList.last == current) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public type next() {
        if(!linkList.isEmpty()) {
            if(current != null) {
                current = current.next;
            } else {
                current = linkList.first;

            }
            return current.getData();
        }
        return null;
    }

    @Override
    public void remove() {
        if(current.prev != null && current.next != null) {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        } else if(current.next != null) {
            current.next.prev = null;

        } else if(current.prev != null) {
            current.prev.next = null;
        }
     }


}
