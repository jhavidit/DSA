package queue.operations;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueueUsingRecursion {


    public static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty())
            return queue;
        int a = queue.remove();
        Queue<Integer> q = reverseQueue(queue);
        queue.add(a);
        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(5);
        queue.add(4);
        queue.add(3);
        queue.add(2);
        queue.add(1);
        System.out.println(queue);
        System.out.println(reverseQueue(queue));
        System.out.println(queue);
    }
}
