package binaryTree.basic;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrderUsing2Stack {

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

    IterativePostOrderUsing2Stack(int key) {
        root = new Node(key);
    }

    private List<Integer> postorder(Node root) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        while (!stack1.isEmpty()) {
            Node pointer = stack1.pop();
            stack2.push(pointer);
            if (pointer.left != null) {
                stack1.push(pointer.left);
            }
            if (pointer.right != null) {
                stack1.push(pointer.right);
            }
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.pop().data);
        }

        return list;

    }

    IterativePostOrderUsing2Stack() {
        root = null;
    }

    public static void main(String[] args) {
        IterativePostOrderUsing2Stack tree = new IterativePostOrderUsing2Stack();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);
        System.out.println(tree.postorder(tree.root));


    }

}
