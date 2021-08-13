package stack.basic;

import java.util.Stack;

public class QueueUsingSingleStack {
    int count = 0;
    Stack<Integer> stack = new Stack<>();

    void enQueue(int x) {
        stack.push(x);
        count++;
    }

    int deQueue() {
        if (stack.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        } else if (stack.size() == 1) {
            return stack.pop();
        } else {
            int val = stack.pop();
            int res = deQueue();
            stack.push(val);
            return res;
        }
    }

    public static void main(String[] args) {
        QueueUsingSingleStack stack = new QueueUsingSingleStack();
        stack.enQueue(5);
        stack.enQueue(4);
        stack.enQueue(3);
        stack.enQueue(2);
        stack.enQueue(1);
        System.out.println(stack.stack);
        System.out.println("Popped : "+stack.deQueue());
        System.out.println(stack.stack);
    }

}
