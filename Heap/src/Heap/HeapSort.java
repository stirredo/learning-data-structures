package Heap;

import javax.xml.crypto.Data;
import java.sql.DataTruncation;

/**
 * Created by stirredo on 6/19/2014.
 *
 */
public class HeapSort {
    private static class DataItem<type extends Comparable<type>> implements Comparable<type> {
        public type data;

        public DataItem(type data) {
            this.data = data;
        }

        public void displayData() {
            System.out.println(data.toString());
        }
        @Override
        public int compareTo(type o) {
            return data.compareTo(o);
        }

    }

    private static class Heap<type extends Comparable<type>> {
        private DataItem<type> array[];
        public int size;
        public int count;

        public Heap(int size) {
            this.size = size;
            array = (DataItem<type>[]) new DataItem[size];
            count = 0;
        }

        private void trickleUp(int index) {
            DataItem<type> parent;
            int parentIndex;
            do {
                if (index <= 0) {
                    return;
                }
                parentIndex = (index - 1) / 2;
                parent = array[parentIndex];
                if (parent != null) {
                    if (array[index].data.compareTo(parent.data) > 0) {
                        swap(index, parentIndex);
                        index = parentIndex;

                    }
                }
            } while (array[index].data.compareTo(parent.data) > 0);
        }

        private void trickleDown(int index) {
            DataItem<type> leftChild;
            DataItem<type> rightChild;
            do {
                int leftChildIndex = (2 * index) + 1;
                int rightChildIndex = (2 * index) + 2;
                leftChild = array[leftChildIndex];
                rightChild = array[rightChildIndex];
                if (leftChild != null && rightChild != null) {
                    if (leftChild.data.compareTo(rightChild.data) > 0) {
                        if (array[index].data.compareTo(leftChild.data) < 0) {
                            swap(index, leftChildIndex);
                            index = leftChildIndex;
                        }
                    } else {
                        if (array[index].data.compareTo(rightChild.data) < 0) {
                            swap(index, rightChildIndex);
                            index = rightChildIndex;
                        }
                    }

                } else if (leftChild != null) {
                    if (array[index].data.compareTo(leftChild.data) > 0) {
                        swap(index, leftChildIndex);
                        index = leftChildIndex;
                    }
                } else if (rightChild != null) {
                    if (array[index].data.compareTo(rightChild.data) > 0) {
                        swap(index, rightChildIndex);
                        index = rightChildIndex;
                    }
                }


            }
            while (array[index].data.compareTo(leftChild.data) > 0 && array[index].data.compareTo(rightChild.data) > 0);

        }

        private void swap(int index, int parentIndex) {
            DataItem<type> temp = array[index];
            array[index] = array[parentIndex];
            array[parentIndex] = temp;

        }

        public boolean insert(type data) {
            DataItem<type> temp = new DataItem<type>(data);
            if (count != size) {
                array[count] = temp;
                trickleUp(count);
                count++;
                return true;
            } else {
                return false;
            }
        }

        public DataItem<type> remove() {
            if (count != 0) {
                DataItem<type> temp = array[0];
                array[0] = array[count - 1];
                count--;
                if (count > 1) {
                    trickleDown(0);
                }
                return temp;
            } else {
                return null;
            }
        }

        public boolean isEmpty() {
            if (count == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<Integer>(10);
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(40);
        heap.insert(50);
        heap.insert(60);
        while (!heap.isEmpty()) {
            DataItem<Integer> temp = heap.remove();
            if (temp != null) {
                temp.displayData();
            }
        }
    }
}
