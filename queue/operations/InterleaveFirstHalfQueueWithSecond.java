package queue.operations;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleaveFirstHalfQueueWithSecond {

    public void interleave(Queue<Integer> queue) {
        int l = queue.size();
        Stack<Integer> stack = new Stack<>();

        while (queue.size() != l / 2) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < l / 2; i++) {
            queue.add(queue.remove());
        }

        for (int i = 0; i < l / 2; i++) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
            queue.add(queue.remove());
        }
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        InterleaveFirstHalfQueueWithSecond obj = new InterleaveFirstHalfQueueWithSecond();
        queue.add(11);
        queue.add(12);
        queue.add(13);
        queue.add(14);
        queue.add(15);
        queue.add(16);
        queue.add(17);
        queue.add(18);
        queue.add(19);
        queue.add(20);
        obj.interleave(queue);
        System.out.println(queue);
    }
}
