package binaryTree.basic;

public class ChildrenSumProperty {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    ChildrenSumProperty(int data) {
        root = new Node(data);
    }

    ChildrenSumProperty() {
        root = null;
    }

    public void changeTree(Node root) {
        if (root == null)
            return;
        int child = 0;
        if (root.left != null) {
            child += root.left.data;
        }
        if (root.right != null) {
            child += root.right.data;
        }
        if (root.data > child) {
            if (root.right != null) root.right.data = root.data;
            if (root.left != null) root.left.data = root.data;
        } else {
            root.data = child;
        }
        changeTree(root.left);
        changeTree(root.right);
        int total = 0;
        if (root.left != null) total += root.left.data;
        if (root.right != null) total += root.right.data;
        if (root.left != null || root.right != null) root.data = total;
    }


    public static void main(String[] args) {
        ChildrenSumProperty tree = new ChildrenSumProperty();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);
    }

}
