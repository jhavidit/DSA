package stack.basic;

public class MergeableStack {
    Node head;
    Node tail;

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
        if (head == null) {
            new_node.next = null;
            new_node.prev = null;
            head = new_node;
            tail = new_node;
        } else {
            new_node.next = head;
            new_node.prev = null;
            head.prev = new_node;
            head = new_node;
        }
    }

    void pop() {
        if (head == null) {
            System.out.println("Stack Underflow");
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    void merge(MergeableStack stack) {
        tail.next = stack.head;
        stack.head.prev = tail;
    }


    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeableStack stack1 = new MergeableStack();
        MergeableStack stack2 = new MergeableStack();
        stack1.push(6);
        stack1.push(5);
        stack1.push(4);
        stack2.push(9);
        stack2.push(8);
        stack2.push(7);
        stack1.display();
        stack2.display();
        stack1.merge(stack2);
        stack1.display();
    }

}
