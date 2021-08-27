package stack.basic;

public class StackLinkedList {

    StackNode top;

    static class StackNode {
        int data;
        StackNode next;

        StackNode(int data) {
            this.data = data;
            next = null;
        }


    }

    void isEmpty() {
        System.out.println(top == null);
    }

    void push(int data) {
        StackNode newNode = new StackNode(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    void reverse() {
        StackNode prev = null;
        StackNode curr = top;
        while (curr != null) {
            StackNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        top = prev;

    }

    void pop() {
        if (top == null)
            System.out.println("stack underflow");
        else {
            System.out.println("Popped = " + top.data);
            top = top.next;
        }
    }

    void display() {
        if (top == null)
            System.out.println("stack underflow");
        else {
            StackNode temp = top;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        stack.top = null;
        stack.push(5);
        stack.push(6);
        stack.push(8);
        stack.push(9);
        stack.display();
        stack.reverse();
        stack.display();
        stack.isEmpty();
    }

}
