package binaryTree.basic;

public class HeightOfBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    HeightOfBinaryTree(int data) {
        root = new Node(data);
    }

    HeightOfBinaryTree() {
        root = null;
    }

    int height(Node node) {
        if (node == null) {
            return 0;
        } else
            return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static void main(String[] args) {
        HeightOfBinaryTree tree = new HeightOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);
        System.out.println(tree.height(tree.root));

    }

}
