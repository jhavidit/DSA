package binaryTree.basic;

import java.util.*;

public class LeftView {

    static class Tuple {
        Node node;
        int x;
        int y;

        Tuple(Node node, int x, int y) {
            this.x = x;
            this.y = y;
            this.node = node;
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

    LeftView(int data) {
        root = new Node(data);
    }

    LeftView() {
        root = null;
    }


    public List<Integer> leftView(Node root) {
        if (root == null)
            return new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0, 0));
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            Node node = tuple.node;
            int x = tuple.x;
            int y = tuple.y;
            if (!map.containsKey(y)) {
                map.put(y, node.data);
            }
            if (node.left != null) {
                queue.add(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                queue.add(new Tuple(node.right, x + 1, y + 1));
            }
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        LeftView tree = new LeftView();
        tree.root = new Node(3);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
        tree.root.right.right = new Node(7);
        tree.root.right.left = new Node(15);
        System.out.println(tree.leftView(tree.root));

    }

}
