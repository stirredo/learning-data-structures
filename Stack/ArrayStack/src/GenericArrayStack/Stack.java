package GenericArrayStack;

import java.util.ArrayList;

/**
 * Created by stirredo on 1/18/14.
 */
public class Stack<type> {
    public ArrayList<type> array;
    public int top;
    public int maxSize;

    public Stack(int maxSize) {
        array = new ArrayList<type>(maxSize);
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
    public void push(type value) {
        try {
            if(!isFull()) {
                top++;
                array.add(value);
            } else {
                throw new StackFullException("Value can not be inserted as stack is at maximum capacity");
            }
        } catch (StackFullException e) {
            System.out.println(e.getMessage());
        }
    }
    public type pop() {
        try {
            if(!isEmpty()) {
                type value = array.get(top);
                array.remove(top);
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
    public type peek() {
        try {

            if (!isEmpty()) {
                return array.get(top);
            } else {
                throw new StackEmptyException("Stack empty. No value to retrieve.");

            }
        } catch (StackEmptyException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
