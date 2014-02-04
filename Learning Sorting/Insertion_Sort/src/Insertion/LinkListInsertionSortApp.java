package Insertion;

/**
 * Created by stirredo on 2/4/14.
 */
public class LinkListInsertionSortApp {
    public static void main(String[] args) {
        LinkListInsertionSort linkList = new LinkListInsertionSort();
        linkList.insert(40);
        linkList.insert(30);
        linkList.insert(20);
        linkList.insert(10);
        linkList.display();
        linkList.sort();
        linkList.display();
    }
}
