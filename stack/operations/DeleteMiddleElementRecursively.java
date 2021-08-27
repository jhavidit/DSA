package stack.operations;

import java.util.Stack;

public class DeleteMiddleElementRecursively {
    public static Stack<Integer> stack = new Stack<>();

    public static void delete(int n) {
        if (stack.size() == n / 2) {
            stack.pop();
            return;
        }
        int a = stack.pop();
        delete(n);
        stack.push(a);
    }

    public static void main(String[] args) {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        delete(stack.size());
        System.out.println(stack);
        delete(stack.size());
        System.out.println(stack);
    }

}
