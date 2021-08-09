package stack.basic;

import java.util.Stack;

public class StackPredefined {

    public static void main(String[] args){

        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack);

    }
}
