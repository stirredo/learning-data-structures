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
        public int count;
        public Node<type> parent;
        private static final int ORDER = 4;

        public Node() {
            childArray = (Node<type>[])new Object[ORDER];
            dataArray = (DataItem<type>[]) new Object[ORDER - 1];
            count = 0;
        }

        public boolean isLeaf() {
            return (childArray[0] == null) ? true : false;
        }

        public void insertData(type data) {
            if (count == ORDER) {
                System.out.println("Node is full");
            } else {
                if (count == 0) {
                    dataArray[0] = new DataItem<type>(data);
                } else {
                    int i;
                    for (i = count; i >= 0; i--) {
                        if (data.compareTo(dataArray[i].data) < 0) {
                            dataArray[i + 1] = dataArray[i];
                        } else {
                            break;
                        }
                    }
                    dataArray[i + 1] = new DataItem<type>(data);
                }
            }

        }

        public void display() {
            for (int i = 0; i < count; i++) {
                dataArray[i].display();
                System.out.print("/");
            }
        }

        public DataItem getItem(int index) {
            return dataArray[index];
        }

        public boolean isFull() {
            return (count == ORDER - 1) ? true : false;
        }

        public type findItem(type key) {
            for (int i = 0; i < count; i++) {
                if (dataArray[i] == key) {
                    return dataArray[i].data;
                }
            }
            return null;
        }

        public DataItem removeDataItem() {
            //remove largest item
            DataItem<type> temp = dataArray[count - 1];
            dataArray[count - 1] = null;
            count--;
            return temp;

        }

        public void connectChild(int childIndex, Node<type> child) {
            childArray[childIndex] = child;
            if (child != null) {
                child.parent = this;
            }
        }

        public Node disconnectChild(int childIndex) {
            Node<type> temp = childArray[childIndex];
            childArray[childIndex] = null;
            return temp;
        }
    }

    public Node<type> root = new Node<type>();

}
