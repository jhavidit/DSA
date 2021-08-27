package stack.operations;

import java.util.Stack;

public class SortStackRecursively {
    Stack<Integer> stack = new Stack<>();

    public void sortStackAdd(int x) {
        if (stack.isEmpty() || x >= stack.peek()) {
            stack.push(x);
            return;
        }
        int a = stack.peek();
        stack.pop();
        sortStackAdd(x);
        stack.push(a);
    }

    public void sortStack() {
        if (stack.isEmpty())
            return;
        int a = stack.peek();
        stack.pop();
        sortStack();
        sortStackAdd(a);
    }

    public static void main(String[] args) {
        SortStackRecursively stack = new SortStackRecursively();
        stack.stack.push(4);
        stack.stack.push(6);
        stack.stack.push(7);
        stack.stack.push(2);
        stack.stack.push(11);
        System.out.println(stack.stack);
        stack.sortStack();
        System.out.println(stack.stack);
    }

}
