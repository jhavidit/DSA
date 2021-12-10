package binarySeachTree.basic;

public class Insert {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    Insert(int data) {
        root = new Node(data);
    }

    Insert() {
        root = null;
    }

    public Node insertIntoBST(Node root, int val) {
        if (root == null)
            return new Node(val);
        Node temp = root;
        Node head = root;
        while (root != null) {
            temp = root;
            if (root.data < val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        if (val > temp.data)
            temp.right = new Node(val);
        else
            temp.left = new Node(val);
        return head;

    }


    public static void main(String[] args) {
        Insert tree = new Insert();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);
        tree.insertIntoBST(tree.root, 5);
    }

}
