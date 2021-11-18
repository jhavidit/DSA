package binaryTree.basic;

import java.util.ArrayList;
import java.util.Stack;

public class BoundaryTraversal {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    BoundaryTraversal(int key) {
        root = new Node(key);
    }

    BoundaryTraversal() {
        root = null;
    }

    ArrayList<Integer> arr = new ArrayList<>();

    public boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public void leftBoundary(Node root) {
        while (root != null) {
            if (isLeaf(root))
                return;
            arr.add(root.data);
            if (root.left != null) {
                root = root.left;
            } else
                root = root.right;
        }
    }

    public void rightBoundary(Node root) {
        Stack<Integer> stack = new Stack<>();
        while (root != null) {
            if (isLeaf(root))
                break;
            stack.push(root.data);
            if (root.right != null) {
                root = root.right;
            } else
                root = root.left;
        }
        System.out.println(stack);
        while (!stack.isEmpty()) {
            arr.add(stack.pop());
        }
    }

    public void addLeaf(Node root) {
        if (root != null) {
            if (isLeaf(root))
                arr.add(root.data);
            addLeaf(root.left);
            addLeaf(root.right);
        }

    }

    ArrayList<Integer> boundaryTraversal(Node root) {
        arr.add(root.data);
        leftBoundary(root.left);
        addLeaf(root);
        rightBoundary(root.right);
        return arr;
    }


    public static void main(String[] args) {
        BoundaryTraversal tree = new BoundaryTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);
        System.out.println(tree.boundaryTraversal(tree.root));


    }

}
