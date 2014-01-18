package ArrayStack;

/**
 * Created by stirredo on 1/19/14.
 */
public class StackApp {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(20);
        stack.push(43);
        stack.push(2450);
        stack.push(250);
        stack.push(2230);
        stack.push(230);
        stack.push(220);
        stack.push(210);
        stack.push(270);
        stack.push(260);
        stack.push(260);
        stack.push(260);
        stack.push(260);
        while(!stack.isEmpty()){
            System.out.println(""+stack.pop());
        }
        stack.pop();

    }
}
