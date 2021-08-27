package stack.operations;

import java.util.Stack;

public class ReverseStackRecursively {

    Stack<Integer> stack = new Stack<>();

    void pushAtBottom(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            return;
        }
        int a = stack.peek();
        stack.pop();
        pushAtBottom(val);
        stack.push(a);
    }

    void reverse() {
        if (stack.empty())
            return;
        int a = stack.peek();
        stack.pop();
        reverse();
        pushAtBottom(a);
    }

    public static void main(String[] args) {
        ReverseStackRecursively stack = new ReverseStackRecursively();
        stack.stack.push(6);
        stack.stack.push(5);
        stack.stack.push(12);
        stack.stack.search(23);
        stack.stack.push(324);
        System.out.println(stack.stack);
        stack.reverse();
        System.out.println(stack.stack);
    }


}
