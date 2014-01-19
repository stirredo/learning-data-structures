package BracketChecker;
import GenericArrayStack.Stack;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by stirredo on 1/19/14.
 */
public class BracketCheckerClass {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>(10);
        String input;
        try {
            input = getString();
            int length = input.length();
            for (int i = 0; i < length; i++){
            char ch = input.charAt(i);
                switch (ch) {
                    case '{':
                    case '[':
                    case '(':
                        stack.push(ch);
                        break;
                    case '}':
                    case ']':
                    case ')':
                        if(!stack.isEmpty()) {
                            char chx = stack.pop();
                            //System.out.println("ch is "+ch+" chx is "+chx);
                            if((ch == '}' && chx != '{') || (ch == ']' && chx != '[') || (ch == ')' && chx !='(')) {
                                System.out.println("Error: "+ch+" at "+i);
                            }

                        } else {
                            System.out.println("Error: "+ch+" at "+i);
                        }
                        break;
                    default:
                        break;


                }
            }
            if (!stack.isEmpty()) {
                //System.out.println(stack.pop());
                System.out.println("Error: missing right delimiter.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static String getString() throws IOException {
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        System.out.flush();
        return input;
    }
}
