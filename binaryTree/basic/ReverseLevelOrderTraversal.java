package binaryTree.basic;

import java.util.*;

public class ReverseLevelOrderTraversal {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    ReverseLevelOrderTraversal(int data) {
        root = new Node(data);
    }

    ReverseLevelOrderTraversal() {
        root = null;
    }


    public ArrayList<Integer> reverseLevelOrder(Node node) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (node == null)
            return arr;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Stack<Integer> stack = new Stack<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.remove();
                stack.push(temp.data);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }

            }
            System.out.println(stack);
            while (!stack.isEmpty()) {
                arr.add(0, stack.pop());
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        ReverseLevelOrderTraversal tree = new ReverseLevelOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);
        tree.root.left.left = new Node(6);
        tree.root.left.right = new Node(8);
        System.out.println(tree.reverseLevelOrder(tree.root));

    }


}
