package ExpressionEvaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Converts a infix expression to postfix and evaluates.
 *
 * Created by stirredo on 2/6/14.
 */

public class PostfixToInfix {
    private String expression;
    private List<Character> list;
    private Stack<Character> stack;
    public PostfixToInfix(String expression) {
        this.expression = expression;
        this.list = new ArrayList<Character>();
        this.stack = new Stack<Character>();
    }
    private boolean isOperator(char ch) {
        switch(ch) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
            default:
                return false;
        }
    }
    private boolean isOperand(char ch) {
        if(Character.isDigit(ch)) {
            return true;
        } else {
            return false;
        }
    }
    private  boolean isParenthesis(char ch) {
        if(ch == '(' || ch == ')') {
            return true;
        } else {
            return false;
        }
    }
    private  int getPrecedence(char ch) {
        switch(ch) {
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            default:
                return 0;
        }
    }
    private boolean checkParenthesis() {
        Stack<Character> bracketStack = new Stack<Character>();
        char popedChar;
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    bracketStack.push(ch);
                    break;
                case ')':
                    popedChar = bracketStack.pop();
                    if(popedChar != '(') {
                        return false;
                    }
                    break;
                case '}':
                    popedChar = bracketStack.pop();
                    if(popedChar != '{') {
                        return false;
                    }
                    break;
                case ']':
                    popedChar = bracketStack.pop();
                    if(popedChar != '[') {
                        return false;
                    }
                    break;
            }


        }
        return true;
    }
    private boolean validate() {
        boolean prevCharOperator = false;
        for (int j = 0; j < expression.length(); j++) {
            char ch = expression.charAt(j);
            if(!(isOperator(ch) || isOperand(ch) || Character.isWhitespace(ch) || isParenthesis(ch))) {
                return false;
            }


                if(isOperator(expression.charAt(j))) {
                    if(prevCharOperator == true) {
                        return false;
                    } else {
                        prevCharOperator = true;
                    }
                } else if(ch == '(') {
                    if(prevCharOperator == false) {
                        return false;
                    }
                } else {
                    prevCharOperator = false;
                }
            }


        if(!checkParenthesis()) {
            return false;
        }
        return true;
    }



/*
    * Operators rule:
            * if newOperator > stackOperator -> push to stack
            * if newOperator == stackOperator -> (pop stack till empty and then push) or (newOperator > stackOperator -> push to stack)
            * if newOperator < stackOperator -> (pop stack till empty and then push) or (newOperator > stackOperator -> push to stack)
            *
*/
    public void convert() {
        if(!expression.isEmpty()) {
            int i = 0;
            char ch;
            while (i < expression.length()){
                ch = expression.charAt(i);
                if (isOperand(ch)) {
                    list.add(ch);
                    i++;
                } else if(isOperator(ch)) {
                    if(stack.isEmpty()) {
                        stack.push(ch);
                        i++;
                    } else {
                        char stackOperator = stack.peek();
                        if(getPrecedence(ch) > getPrecedence(stackOperator)) {
                            stack.push(ch);
                            i++;
                        } else {
                            list.add(stack.pop());

                        }
                    }
                } else if (isParenthesis(ch)) {
                    if(ch == '(') {
                        stack.push(ch);
                        i++;
                    } else if (ch == ')'){
                        while((ch = stack.peek()) != '(') {
                            list.add(stack.pop());
                        }
                        stack.pop(); //remove '(' from stack
                        i++;
                    }
                }
            }
            while(!stack.isEmpty()) {
                list.add(stack.pop());
            }

        } else {
            System.out.println("String is empty. Can't process");

        }

    }
    public int evaluateExpression() {
        Stack<Integer> evalStack = new Stack<Integer>();
        if(!list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                char ch = list.get(i);
                if(isOperand(ch)) {
                    evalStack.push(Character.getNumericValue(ch));
                } else if (isOperator(ch)) {
                    if(evalStack.size() >= 2) {
                        int first, second, result;
                        second = evalStack.pop().intValue();
                        first =  evalStack.pop().intValue();
                        result = calculate(first, second, ch);
                        evalStack.push(result);
                    }
                }

            }
            if(evalStack.size() == 1) {
                return evalStack.pop();

            } else {
                System.out.println("Something went wrong while evaluating. Too many or none values to evaluate stack.");
                return 0;
            }
        } else {
            System.out.println("Expression empty. Cannot evaluate.");
            return 0;
        }
    }
    private int calculate(int first,int second,char operator) {
        switch (operator) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                return first / second;
            default:
                return 0;
        }
    }
    public static void main(String[] args) {
        String expression = "4+(7*9-4)-9";
        PostfixToInfix pi = new PostfixToInfix(expression);
        if(pi.validate()) {
            pi.convert();
            for (char c: pi.list) {
                System.out.print(c + " ");

            }
            System.out.println("");
            System.out.println(pi.evaluateExpression());
        } else {
            System.out.println("Nope. Doesn't work");
        }

    }
}
