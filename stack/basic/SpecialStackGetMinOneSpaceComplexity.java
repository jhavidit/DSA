package stack.basic;

import java.util.Stack;

public class SpecialStackGetMinOneSpaceComplexity {
    Stack<Integer> stack = new Stack<>();
    int min = -1;

    void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            min = x;
        } else if (x >= min) {
            stack.push(x);
        } else {
            stack.push(2 * x - min);
            min = x;
        }

    }

    void pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack Underflow");
            return;
        }
        int val = stack.pop();

        if (val >= min) {
            System.out.println("Popped : " + val);
        } else {
            System.out.println("Popped : " + min);
            min = 2 * min - val;
        }
    }

    void peek() {
        if (stack.isEmpty()) {
            System.out.println("Stack Underflow");
            return;
        }
        int val = stack.peek();
        if (val < min) {
            System.out.println("Peeked : " + min);
        } else
            System.out.println("Peeked : " + val);
    }


    int getMin() {
        return min;
    }

    public static void main(String[] args) {
        SpecialStackGetMinOneSpaceComplexity stack = new SpecialStackGetMinOneSpaceComplexity();
        stack.push(4);
        stack.push(2);
        stack.push(8);
        stack.push(67);
        stack.push(1);
        System.out.println(stack.getMin());
        stack.peek();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
        stack.peek();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());

    }
}
