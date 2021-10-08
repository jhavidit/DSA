package linkedList;

public class RemoveNthNodeFromLinkedList {

    Node head;

    public static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void pushAtEnd(int d) {
        Node newNode = new Node(d);
        Node temp = head;
        if (temp == null) {
            head = newNode;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
        newNode.next = null;
    }

    public Node removeNthFromEnd(Node head, int n) {
        int c = 0;
        Node temp = head;
        while (head != null && c != n) {
            temp = temp.next;
            c++;
        }
        Node ptr = head;
        Node prev = head;
        while (temp != null) {
            prev = ptr;
            temp = temp.next;
            ptr = ptr.next;
        }
        if (ptr == prev) {
            ptr = ptr.next;
            head = ptr;
        } else {
            prev.next = ptr.next;
        }
        return head;
    }

}
