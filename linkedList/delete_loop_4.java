package linkedList;

import java.util.HashSet;

public class delete_loop_4 {

    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    public static void removeLoop(Node head) {

        HashSet<Node> h = new HashSet();
        Node temp = head;
        Node prev = null;
        h.add(head);
        while (temp != null) {
            prev = temp;
            temp = temp.next;
            if (h.contains(temp)) {
                prev.next = null;
                break;
            } else
                h.add(temp);

        }
    }
}
