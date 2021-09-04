package queue.operations;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementsOfQueue {
    public boolean reverse = false;

    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        if (!reverse) {
            reverseQueue(q);
            reverse = true;
            k = q.size() - k;
        }
        if (k == 0)
            return q;
        int a = q.remove();
        Queue<Integer> Q = modifyQueue(q, k - 1);
        q.add(a);
        return q;
    }


    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty())
            return;
        int a = queue.remove();
        reverseQueue(queue);
        queue.add(a);

    }

    public static void main(String[] args) {
        ReverseFirstKElementsOfQueue obj = new ReverseFirstKElementsOfQueue();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        obj.modifyQueue(queue, 3);
        System.out.println(queue);
    }
}
