package DoublyDoubleEndedLinkList;

import java.util.Iterator;

/**
 * Created by stirredo on 2/3/14.
 */
public class DoublyDoubleEndedLinkList<type> implements Iterable<type> {
    public DoublyNode first;
    public DoublyNode last;
    public DoublyDoubleEndedLinkList() {
        first = null;
        last = null;
    }
    public boolean isEmpty() {
        if(first == null) {
            return true;
        } else {
            return false;
        }
    }
    public void insertFirst(type data) {
        DoublyNode<type> newNode = new DoublyNode(data);
        if(!isEmpty()) {
                DoublyNode<type> temp = first;
                newNode.next = temp;
                temp.prev = newNode;
                first = newNode;

        } else {
            first = newNode;
            last = newNode;
        }
    }
    public void insertLast(type data) {
        DoublyNode<type> newNode = new DoublyNode(data);
        if(!isEmpty()) {
            DoublyNode<type> temp = last;
            temp.next = newNode;
            newNode.prev = temp;
            last = newNode;
        } else {
            first = newNode;
            last = newNode;
        }
    }
    public DoublyNode<type> deleteLast() {
        if(!isEmpty()) {
            DoublyNode<type> temp = last;
            temp.prev.next = null;
            last = temp.prev;
            return temp;
        } else {
            System.out.println("Link list is empty.");
            return null;
        }
    }
    public DoublyNode<type> deleteFirst() {
        if(!isEmpty()) {
            DoublyNode<type> temp = first;
            first = temp.next;
            temp.next.prev = null;
            return temp;
        } else {
            System.out.println("List empty. Couldn't delete.");
            return null;
        }

    }
    public DoublyNode<type> peekFirst() {
        if(!isEmpty()) {
            return this.first;
        } else {
            return null;
        }
    }
    public DoublyNode<type> peekLast() {
        if(!isEmpty()) {
            return this.last;
        } else {
            return null;
        }
    }
    public void displayList() {
        if(!isEmpty()) {
            DoublyNode<type> current = first;
            System.out.print("first -> last: ");
            while(current != null) {
                current.displayNode();
                System.out.print(" ");
                current = current.next;
            }
            System.out.println("");
        } else {
            System.out.println("List empty. Nothing to display.");
        }
    }

    public static void main(String[] args) {

    }


    @Override
    public Iterator<type> iterator() {
        return new DoublyLinkListIterator<type>(this);
    }
}
