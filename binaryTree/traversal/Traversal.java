package binaryTree.traversal;

public class Traversal {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

    }

    Node root;

    Traversal(int data) {
        root = new Node(data);
    }

    Traversal() {
        root = null;
    }

    public void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    public void preorderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public void postorderTraversal(Node root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Traversal obj = new Traversal(5);
        obj.root.right = new Node(4);
        obj.root.left = new Node(2);
        obj.root.left.left = new Node(6);
        obj.root.left.right = new Node(1);
        obj.root.right.right = new Node(11);
        obj.inorderTraversal(obj.root);
        System.out.println();
        obj.postorderTraversal(obj.root);
        System.out.println();
        obj.preorderTraversal(obj.root);

    }

}
