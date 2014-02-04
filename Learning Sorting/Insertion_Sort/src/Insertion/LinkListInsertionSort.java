package Insertion;
import DoublyDoubleEndedLinkList.DoublyDoubleEndedLinkList;
import DoublyDoubleEndedLinkList.DoublyNode;


/**
 * Created by stirredo on 2/2/14.
 */
/*
* insert
* sort
* display
* swap
* */

public class LinkListInsertionSort {
    DoublyDoubleEndedLinkList<Integer> linkList = new DoublyDoubleEndedLinkList<Integer>();
    public void insert(Integer data) {
        linkList.insertLast(data);
    }
    public void display() {
        linkList.displayList();

    }
    public void sort() {
        DoublyNode<Integer> outer = linkList.first;
        while(outer != null) {
                DoublyNode<Integer> inner = outer.prev;
                while(inner != null) {
                    Integer nextValue = (Integer)inner.next.data;
                    if(inner.data.intValue() > nextValue.intValue()) {
                        swap(inner,inner.next);
                    } else {
                        break;
                    }
                    inner = inner.prev;

                }
            outer = outer.next;
        }
    }
    private void swap(DoublyNode<Integer> nodeOne,DoublyNode<Integer> nodeTwo) {
        Integer temp = nodeOne.data;
        nodeOne.data = nodeTwo.data;
        nodeTwo.data = temp;
    }



}
