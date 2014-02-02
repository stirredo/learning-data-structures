package LinkList;

/**
 * Created by stirredo on 1/29/14.
 */
public class DoubleEndedLinkList {
    public Node first;
    public Node last;
    public DoubleEndedLinkList() {
        first = null;
        last = null;
    }


    public void insertFirst(int data) {
        if(!isEmpty()) {
            Node temp = first;
            Node newNode = new Node(data);
            newNode.next = temp;
            first = newNode;


        } else {
            Node newNode = new Node(data);
            this.first = newNode;
            this.last = newNode;
        }
    }

    public void insertLast(int data) {
        if(!isEmpty()) {
            Node newNode = new Node(data);
            Node temp = last;
            temp.next = newNode;
            last = newNode;
        } else {
            Node newNode = new Node(data);
            first = newNode;
            last = newNode;
        }
    }



    public Node deleteFirst() {
        if(!isEmpty()) {
            if(first == last) {
                Node temp = first;
                first = null;
                last = null;
                return temp;
            } else {
                Node temp = first;
                first = temp.next;
                return temp;
            }

        } else {
            System.out.println("Link list empty; nothing to delete.");
            return null;
        }
    }

    public boolean isEmpty() {
        if(this.first == null) {
            return true;
        } else {
            return false;
        }

    }


    public Node deleteLast() {
        if(!isEmpty()) {
            if(first == last) {
                Node temp = first;
                first = null;
                last = null;
                return temp;
            } else {
                Node traverseTemp = first;
                while(traverseTemp.next != this.last) {
                    traverseTemp = traverseTemp.next;
                }
                traverseTemp.next = null;
                this.last = traverseTemp;
                return last;

            }
        } else {
            System.out.println("Link list empty; nothing to delete.");
            return null;

        }
    }
    public Node peekFirst() {
        if(!isEmpty()) {
            return first;
        } else {
            return null;
        }
    }
    public Node peekLast() {
        if(!isEmpty()) {
            return last;
        } else {
            return null;
        }
    }

    public void displayList() {
        if(!isEmpty()) {
            Node temp = first;
            System.out.print("first -> last: ");
            while(temp != null) {

                temp.displayNode();
                System.out.print(" ");
                temp = temp.next;



            }
        } else {
            System.out.println("Link list is empty.");
        }


    }

    public static void main(String[] args) {

    }

}
