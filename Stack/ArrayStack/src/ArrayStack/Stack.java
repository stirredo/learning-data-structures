package ArrayStack;

import java.util.EmptyStackException;

/**
 * Created by stirredo on 1/18/14.
 */
public class Stack {
    public Integer[] array;
    public int top;
    public int maxSize;

    public Stack(int maxSize) {
        array = new Integer[maxSize];
        top = -1;
        this.maxSize = maxSize;
    }
    public boolean isFull() {
        if(top == (maxSize-1)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isEmpty() {
        if(top == -1) {
            return true;
        } else {
            return false;
        }
    }
    public void push(Integer value) {
        try {
            if(!isFull()) {
                top++;
                array[top] = value;
            } else {
                throw new StackFullException("Value can not be inserted as stack is at maximum capacity");
            }
        } catch (StackFullException e) {
            System.out.println(e.getMessage());
        }
    }
    public Integer pop() {
        try {
            if(!isEmpty()) {
                Integer value = array[top];
                array[top] = null;
                top--;
                return value;
            } else {
                throw new StackEmptyException("Stack empty. No value to retrieve.");
            }
        } catch (StackEmptyException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    public Integer peek() {
        try {

            if (!isEmpty()) {
                return array[top];
            } else {
                throw new StackEmptyException("Stack empty. No value to retrieve.");

            }
        } catch (StackEmptyException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
