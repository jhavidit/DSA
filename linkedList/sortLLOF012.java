package linkedList;

public class sortLLOF012 {

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

    Node segregate(Node head) {
        int[] count = {0, 0, 0};
        Node temp = head;
        while (temp != null) {
            count[temp.data]++;
            temp = temp.next;
        }
        temp = head;
        int i = 0;
        while (temp!=null){
            if(count[i]==0){
                i++;
            }
            else {
                temp.data = i;
                --count[i];
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        sortLLOF012 obj = new sortLLOF012();
        obj.pushAtEnd(1);
        obj.pushAtEnd(2);
        obj.pushAtEnd(2);
        obj.pushAtEnd(1);
        obj.pushAtEnd(2);
        obj.pushAtEnd(0);
        obj.pushAtEnd(2);
        obj.pushAtEnd(2);
        obj.display();
        obj.head = obj.segregate(obj.head);
        obj.display();
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


}
