package DoublyDoubleEndedLinkList;

import LinkList.DoubleEndedLinkList;

import java.util.Iterator;

/**
 * Created by stirredo on 2/4/14.
 */
public class DoublyDoubleEndedLinkListApp {
    public static void main(String[] args) {
        DoublyDoubleEndedLinkList<Integer> linkList = new DoublyDoubleEndedLinkList<Integer>();
        linkList.insertFirst(10);
        linkList.insertFirst(20);
        linkList.insertLast(30);
        linkList.insertLast(40);
        linkList.insertLast(50);
        for (Integer data: linkList) {
            System.out.print(data+" ");


        }
        System.out.println("");
        Iterator<Integer> iter = new DoublyLinkListIterator<Integer>(linkList);
        while(iter.hasNext()) {
            if(iter.next().intValue() == 30) {
                iter.remove();
            }
        }
        for (Integer data: linkList) {
            System.out.print(data+" ");


        }

    }
}
