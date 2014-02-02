package LinkList;

/**
 * Created by stirredo on 1/29/14.
 */
public class LinkListApp {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.insertLast(10);
        linkList.insertLast(20);
        linkList.insertLast(30);
        linkList.insertLast(40);
        linkList.deleteLast();
        linkList.deleteFirst();
        linkList.insertFirst(10);


        linkList.displayList();
    }



}
