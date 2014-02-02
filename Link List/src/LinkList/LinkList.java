package LinkList;

/**
 * Created by stirredo on 1/27/14.
 */
public class LinkList {
    protected Node first;

    public LinkList() {
        first = null;
    }

    public void insertFirst(int data) {
        if(!isEmpty()) {
        Node temp = first;
        Node newNode = new Node(data);
        newNode.next = temp;
        this.first = newNode;
        } else {
            this.first = new Node(data);
        }
    }
    public void insertLast(int data) {
        if (!isEmpty()) {
            Node temp = first;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
        } else {
            this.first = new Node(data);
        }

    }
    public Node deleteFirst() {
        if (!isEmpty()) {
            Node temp = first;
            this.first = first.next;
            return temp;
        } else {
            System.out.println("Link list is empty");
            return null;
        }
    }
    public boolean isEmpty() {
        if(this.first == null) {
            return true;
        }
        return false;
    }
    public void displayList() {
        if(!isEmpty()) {
            System.out.print("first->last: ");
            Node temp = first;
            while(temp != null) {
                System.out.print(temp.data+" ");
                temp = temp.next;

            }

        } else {
            System.out.println("Link list empty dickwad.");
        }
    }
    public Node find(int key) {
        if(!isEmpty()) {
            Node temp = first;
            while(temp.data != key) {
                if(temp.next == null) {
                    return null;
                } else {
                    temp = temp.next;
                }
            }
            return temp;
        } else {
            return null;
        }
    }
    public Node delete(int key) {
        if(!isEmpty()) {
            Node current = this.first;
            Node previous = null;
            while(current.data != key) {

                if(current.next == null) {
                    return null;
                } else {
                    previous = current;
                    current = current.next;

                }

            }

            if(previous != null) {
                previous.next = current.next;

            } else {
                this.first = null;
            }
            return current;
        } else {
            System.out.println("List empty; Nothing there to delete.");
            return null;
        }

    }
    public Node deleteLast() {
        Node current = this.first;
        Node previous = null;
        if(!isEmpty()) {
            while(current.next != null) {
                previous = current;
                current = current.next;
            }
            if(previous == null) {
                this.first = null;

            } else {
                previous.next = null;
            }
            return current;
        } else {
            System.out.println("List empty; nothing to delete.");
            return null;
        }

    }

    public static void main(String[] args) {

    }


}
