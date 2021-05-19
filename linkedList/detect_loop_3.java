package linkedList;

// { Driver Code Starts
// driver code

import java.util.*;

public class detect_loop_3 {

    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    /*Function to check if the linked list has a loop using hashing storing node in hashset if its already present or not
     Time Complexity - O(n)
    Space Complexity - O(n);*/
    public static boolean detectLoopUsingHashing(Node head) {
        HashSet<Node> h = new HashSet();
        Node temp = head;
        while (temp != null) {
            if (h.contains(temp))
                return true;
            else
                h.add(temp);
            temp = temp.next;
        }
        return false;
    }

    /* Using FLoyd Cycle - Finding Algorithm
    here we have slow and fast pointer slow pointer shift one position fast pointer shift 2 position
    if fast and slow pointer overlap then loop is present.
    Time Complexity - O(n)
    Space Complexity - O(1) */
    public static boolean detectLoopUsingFLoydCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;

    }
}