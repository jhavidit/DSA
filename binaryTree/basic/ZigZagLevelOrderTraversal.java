package binaryTree.basic;

import java.util.*;

public class ZigZagLevelOrderTraversal {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    ZigZagLevelOrderTraversal(int data) {
        root = new Node(data);
    }

    ZigZagLevelOrderTraversal() {
        root = null;
    }


    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        boolean left = false;
        if (root == null)
            return list;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            int size = queue.size();
            if (left) {
                for (int i = 0; i < size; i++) {
                    Node remove = queue.remove();
                    l.add(0, remove.data);
                    if (remove.left != null)
                        queue.add(remove.left);
                    if (remove.right != null)
                        queue.add(remove.right);
                }
                list.add(l);
                left = false;
            } else {
                for (int i = 0; i < size; i++) {
                    Node remove = queue.remove();
                    l.add(remove.data);
                    if (remove.left != null)
                        queue.add(remove.left);
                    if (remove.right != null)
                        queue.add(remove.right);
                }
                list.add(l);
                left = true;
            }

        }
        return list;
    }


    public static void main(String[] args) {
        ZigZagLevelOrderTraversal tree = new ZigZagLevelOrderTraversal();
        tree.root = new Node(3);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
        tree.root.right.right = new Node(7);
        tree.root.right.left = new Node(15);
        System.out.println(tree.zigzagLevelOrder(tree.root));

    }


}
