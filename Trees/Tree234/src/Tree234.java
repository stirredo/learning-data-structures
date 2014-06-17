import java.util.Comparator;

/**
 * 2-3-4 Tree implementation
 * Created by stirredo on 7/6/2014.
 * -- First time tried to make it a true generic class
 */
public class Tree234<type extends Comparable<type>> {
    private class DataItem<type extends Comparable<type> > implements Comparable<type> {
        type data;
        public DataItem(type data) {
            this.data = data;
        }
        public void display() {
            System.out.print(data.toString());

        }

        @Override
        public int compareTo(type o) {
            return data.compareTo(o);
        }
    }

    private class Node<type extends Comparable<type>> {
        public Node<type>[] childArray;
        public DataItem<type>[] dataArray;
        public int dataCount; //No. of data elements in the node
        public int childCount; //No. of child elements under it
        public Node<type> parent;
        private static final int ORDER = 4;

        public Node() {

            childArray = (Node<type>[]) new Node[ORDER];
            dataArray = (DataItem<type>[]) new DataItem[ORDER - 1];
            dataCount = 0;
            childCount = 0;
        }

        public boolean isLeaf() {
            return (childArray[0] == null);
        }

        public Integer insertData(type data) {
            if (dataCount == (ORDER - 1)) {
                System.out.println("Node is full");
            } else {
                if (dataCount == 0) {
                    dataArray[0] = new DataItem<type>(data);
                    dataCount++;
                    return 0;
                } else {
                    int i;
                    for (i = (dataCount - 1); i >= 0; i--) {
                        if (data.compareTo(dataArray[i].data) < 0) {
                            dataArray[i + 1] = dataArray[i];
                        } else {
                            break;
                        }
                    }
                    dataArray[i + 1] = new DataItem<type>(data);
                    dataCount++;
                    return i + 1;
                }

            }
            return null;
        }

        public int insertData(DataItem<type> thisNode) {
            if (dataCount == 0) {
                dataArray[0] = thisNode;
                dataCount++;
                return 0;
            } else {
                int i;
                for (i = (dataCount - 1); i >= 0; i--) {
                    if (thisNode.data.compareTo(dataArray[i].data) < 0) {
                        dataArray[i + 1] = dataArray[i];
                    } else {
                        break;
                    }
                }
                dataArray[i + 1] = thisNode;
                dataCount++;
                return i + 1;
            }
        }

        public void display() {
            for (int i = 0; i < dataCount; i++) {
                dataArray[i].display();
                System.out.print("/");
            }
        }

        public DataItem<type> getItem(int index) {
            return dataArray[index];
        }

        public boolean isFull() {
            return (dataCount == ORDER - 1) ? true : false;
        }

        public int findItem(type key) {
            for (int i = 0; i < dataCount; i++) {
                if (dataArray[i].data == key) {
                    return i;
                }
            }
            return -1;
        }

        public DataItem<type> removeDataItem() {
            //remove largest item
            DataItem<type> temp = dataArray[dataCount - 1];
            dataArray[dataCount - 1] = null;
            dataCount--;
            return temp;

        }

        public DataItem<type> removeDataItem(int index) {
            DataItem<type> temp = dataArray[index];
            dataArray[index] = null;
            dataCount--;
            return temp;
        }

        public void connectChild(int childIndex, Node<type> child) {
            childArray[childIndex] = child;
            if (child != null) {
                child.parent = this;
            }
            childCount++;
        }

        public Node<type> disconnectChild(int childIndex) {
            Node<type> temp = childArray[childIndex];
            childArray[childIndex] = null;
            childCount--;
            return temp;
        }
    }

    public Node<type> root;
    public Tree234(){
        root = null;
    }

    public boolean isRoot(Node<type> key) {
        return (root == key) ? true : false;
    }
    public void insert(type data) {
        /*
        * Insertion steps:
        * 1. Start at the root and find a leaf.
        * 2. If you find a Node that is full, split it. (Splitting on the way down)
        *   2a. If the node is not a root:
        *       0. Node structure: [A|B|C]
        *       1. Create a new node and attach it to the parent as a sibling(right) of the node that is being split (Node x).
        *       2. If there are more than 2 children in X, attach it to the sibling node.
        *       3. Element C goes in the sibling node.
        *       4. Element B goes in the parent node.
        *       5. Element A stays in X.
        *   2b. If the node is a root:
        *       1. Create two new nodes. One will be a sibling to the current node (right) and the other will be the
        *       new root.
        *       2. Element C goes in the sibling.
        *       3. Element B goes in the new Root whereas A stays where it was.
        *       4. Attach the sibling and the current root to the new root.
        *       5. Update the reference to new node in the class.
        *       6. If the Node has more than 2 children attach it to them to the siblings.
        * 3. Start at the parent of the split node and check again for the leaf which is suited for insertion
        *   (According to the data)
        *
        * */
        Node<type> temp = root;
        Node<type> parent = null;
        if (temp == null) {
            root = new Node<type>();
            temp = root;
        }
        while (true) {
            if(temp.isFull()) { //split the node
                split(temp);
                temp = temp.parent; //Go back up
                temp = getNextChild(temp, data);
            } else if (temp.isLeaf()) {
                break;
            } else {
                temp = getNextChild(temp, data);
            }

        }
        temp.insertData(data);

    }

    public void split(Node<type> thisNode) {
        DataItem<type> itemC = thisNode.removeDataItem();
        DataItem<type> itemB = thisNode.removeDataItem();
        Node<type> parent;
        Node<type> rightNode = new Node<type>(); // Right Sibling
        if (isRoot(thisNode)) {
            parent = new Node<type>();
            root = parent;
            parent.connectChild(0, thisNode);
            thisNode.parent = root;

        } else {
            parent = thisNode.parent;
        }

        rightNode.insertData(itemC);  // Insert Item C into the right sibling
        if (thisNode.childCount > 2) { // Attach the child node no. 2 and 3 to the sibling node
            Node<type> child2 = thisNode.disconnectChild(2);
            Node<type> child3 = thisNode.disconnectChild(3);
            rightNode.connectChild(0, child2);
            rightNode.connectChild(1, child3);

        }
        int index = parent.insertData(itemB); //Insert Item B into the parent
        for (int i = parent.childCount - 1; i > index; i--) { //Move parent's child one to the right
            Node<type> child = parent.disconnectChild(i);
            parent.connectChild(i + 1, child);

        }
        parent.connectChild(index + 1, rightNode);
    }

    public Node<type> getNextChild(Node<type> thisNode, type data) {
        int i;
        Node<type> temp;
        for (i = 0; i < thisNode.dataCount; i++) {
            if (data.compareTo(thisNode.dataArray[i].data) < 0) {
                return thisNode.childArray[i];
            }
        }
        return thisNode.childArray[i];
    }

    public int find(type key) {
        Node<type> temp = root;
        int childNumber;
        while (true) {
            if ((childNumber = temp.findItem(key)) != -1) {
                return childNumber;
            } else {
                if (temp.isLeaf()) {
                    break; // Can't find it
                } else {
                    temp = getNextChild(temp, key);
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Tree234<Integer> tree = new Tree234<Integer>();
        tree.insert(70);
        tree.insert(50);
        tree.insert(30);
        tree.insert(40);
        tree.insert(20);
        tree.insert(80);
        tree.insert(25);
        tree.insert(90);
        tree.insert(75);
        tree.insert(10);
        if (tree.find(30) != -1) {
            System.out.println("Found");
        } else {
            System.out.println("Couldn't find it.");
        }
    }

}
