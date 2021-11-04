package binaryTree.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreOrder {

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

    IterativePreOrder(int key) {
        root = new IterativePreOrder.Node(key);
    }

    IterativePreOrder() {
        root = null;
    }


    public List<Integer> inorderSort(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            list.add(temp.data);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        IterativePreOrder tree = new IterativePreOrder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);
        System.out.println(tree.inorderSort(tree.root));


    }
}
