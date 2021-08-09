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

    /* storing prev node and the current node in the hashset and iterate when current node is already present in the hashset
    * link the previous node to null hence deleting the node and all the elements are present
    * Time Complexity - O(n)
    * Space Complexity - O(n) */

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
