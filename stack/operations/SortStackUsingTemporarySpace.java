package stack.operations;

import java.util.Stack;

public class SortStackUsingTemporarySpace {
    public static Stack<Integer> stack = new Stack<>();

    public static void sortStack() {
        Stack<Integer> s = new Stack<>();
        while (!stack.isEmpty()) {
            int a = stack.pop();
            if (!s.isEmpty() && a < s.peek()) {
                while (!s.isEmpty() && a < s.peek()) {
                    stack.push(s.pop());
                }
            }
            s.push(a);

        }
        stack.removeAllElements();
        stack.addAll(s);
        s.removeAllElements();
    }

    public static void main(String[] args) {
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(6);
        stack.push(2);
        System.out.println(stack);
        sortStack();
        System.out.println(stack);
    }

}
