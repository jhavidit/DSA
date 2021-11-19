package binaryTree.basic;

import java.util.*;

public class BottomView {

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

    BottomView(int data) {
        root = new Node(data);
    }

    BottomView() {
        root = null;
    }


    public List<Integer> bottomView(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0, 0));
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            Node node = tuple.node;
            int x = tuple.x;
            int y = tuple.y;
                map.put(x, node.data);
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
        BottomView tree = new BottomView();
        tree.root = new Node(3);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
        tree.root.right.right = new Node(7);
        tree.root.right.left = new Node(15);
        System.out.println(tree.bottomView(tree.root));

    }

}
