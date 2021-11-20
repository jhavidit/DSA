package binaryTree.basic;

import javafx.util.Pair;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class MaximumWidthOfBinaryTree {

    static class Pair {
        Node root;
        int value;

        Pair(Node root, int value) {
            this.root = root;
            this.value = value;
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    MaximumWidthOfBinaryTree(int data) {
        root = new Node(data);
    }

    MaximumWidthOfBinaryTree() {
        root = null;
    }

    public int maximumWidth(Node root) {
        if (root == null)
            return 0;
        int size = 1;
        Deque<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair first = queue.peekFirst();
            Pair last = queue.peekLast();
            size = Math.max(size, last.value - first.value + 1);
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                Pair temp = queue.removeFirst();
                if (temp.root.left != null) {
                    queue.add(new Pair(temp.root.left, 2 * (temp.value - 1) + 1));
                }
                if (temp.root.right != null) {
                    queue.add(new Pair(temp.root.right, 2 * (temp.value - 1) + 2));
                }


            }


        }
        return size;

    }

    public static void main(String[] args) {
        MaximumWidthOfBinaryTree tree = new MaximumWidthOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);
        tree.root.left.left = new Node(5);
        System.out.println(tree.maximumWidth(tree.root));

    }

}
