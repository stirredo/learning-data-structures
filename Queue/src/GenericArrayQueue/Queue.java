package GenericArrayQueue;

import java.util.ArrayList;

/**
 * Created by stirredo on 1/20/14.
 */
public class Queue<type> {
    protected int count;
    protected int front;
    protected int rear;
    protected int maxSize;
    public type[] array;
    public Queue(int maxSize) {
        array = (type[]) new Object[maxSize];
        this.maxSize = maxSize;
        rear = -1;
        front = 0;
        count = 0;
    }

    public boolean isEmpty() {
        if(count == 0) {
            return true;
        } else {
            return false;
        }

    }
    public boolean isFull() {
        if(count == maxSize) {
            return true;
        } else {
            return false;
        }

    }
    public boolean insert(type value) {
        if(!isFull()) {
            if(rear == (maxSize - 1)) {
                rear = -1;

            }
            rear++;
            array[rear] = value;
            count++;
            return true;
        } else {
            System.out.println("");
            return false;
        }
    }
    public type delete() {
        if(!isEmpty()) {
            type temp = array[front];
            if(front == (maxSize - 1)) {
                front = 0;
            } else {
                front++;
            }
            count--;
            return temp;

        } else {
            System.out.println("Couldn't perform delete; Queue is empty.");
            return null;
        }
    }
    public type peek() {
        if(!isEmpty()) {
            return array[front];
        } else {
            return null;
        }
    }
}

