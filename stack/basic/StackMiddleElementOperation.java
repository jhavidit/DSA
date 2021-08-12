package stack.basic;

public class StackMiddleElementOperation {
    Node head;
    Node mid;
    int count = 0;

    public static class Node {
        Node prev;
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    void push(int x) {
        Node new_node = new Node(x);
        if (count == 0) {
            new_node.next = head;
            new_node.prev = null;
            head = new_node;
            mid = new_node;
            count++;
        } else if (count % 2 != 0) {
            new_node.prev = null;
            new_node.next = head;
            head.prev = new_node;
            head = new_node;
            count++;
        } else {
            new_node.prev = null;
            new_node.next = head;
            head.prev = new_node;
            head = new_node;
            mid = mid.prev;
            count++;
        }
    }

    void pop() {
        System.out.println("Count : " + count);
        if (count == 0) {
            System.out.println("Stack Underflow");
        } else if (count == 1) {
            mid = null;
            head = null;
            count--;
        } else if (count % 2 == 0) {
            head.next.prev = null;
            head = head.next;
            mid = mid.next;
            count--;
        } else {
            head.next.prev = null;
            head = head.next;
            count--;
        }
    }

    void midElement() {
        if (count == 0)
            System.out.println("Empty Stack");
        else
            System.out.println("Middle Element : " + mid.data);
    }

    void deleteMid() {
        if (count == 0) {
            System.out.println("Empty Stack");
        } else if (count == 1) {
            System.out.println("Deleting mid : " + mid.data);
            head = null;
            mid = null;
            count--;
        } else if (count % 2 != 0) {
            System.out.println("Deleting mid : " + mid.data);
            Node temp = mid;
            mid = mid.next;
            if (temp.prev != null)
                temp.prev.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
            temp.next = null;
            temp.prev = null;
            count--;
        } else {
            System.out.println("Deleting mid : " + mid.data);
            Node temp = mid;
            mid = mid.prev;
            if (temp.prev != null)
                temp.prev.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
            temp.next = null;
            temp.prev = null;
            count--;
        }

    }

    void display() {
        if (head == null) {
            System.out.println("Stack Underflow");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackMiddleElementOperation stack = new StackMiddleElementOperation();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.midElement();
        stack.display();
        stack.deleteMid();
        stack.display();
        stack.deleteMid();
        stack.display();
        stack.midElement();
        stack.deleteMid();
        stack.display();

    }


}
