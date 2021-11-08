package binaryTree.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInOrder {

    static class Node {
        int data;
        IterativeInOrder.Node left;
        IterativeInOrder.Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    IterativeInOrder.Node root;

    IterativeInOrder(int key) {
        root = new IterativeInOrder.Node(key);
    }

    IterativeInOrder() {
        root = null;
    }

    public static void main(String[] args) {
        IterativeInOrder tree = new IterativeInOrder();
        tree.root = new IterativeInOrder.Node(1);
        tree.root.left = new IterativeInOrder.Node(2);
        tree.root.right = new IterativeInOrder.Node(3);
        tree.root.right.right = new IterativeInOrder.Node(4);
        System.out.println(tree.inorder(tree.root));


    }

    private List<Integer> inorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node pointer = root;
        while (true) {
            if (pointer != null) {
                stack.push(pointer);
                pointer = pointer.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                Node temp = stack.pop();
                System.out.println(temp.data);
                list.add(temp.data);
                pointer = temp.right;

            }


        }
        return list;
    }

}
