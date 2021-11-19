package binaryTree.basic;

import java.util.*;

public class VerticalOrderTraversal {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Tuple {
        Node root;
        int x;
        int y;

        Tuple(Node root, int x, int y) {
            this.root = root;
            this.x = x;
            this.y = y;
        }
    }

    Node root;

    VerticalOrderTraversal(int data) {
        root = new Node(data);
    }

    VerticalOrderTraversal() {
        root = null;
    }

    public void coordinate(Node root, int x, int y) {

    }

    public List<List<Integer>> verticalTraversal(Node root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0, 0));
        while (!queue.isEmpty()) {
            Tuple tuple = queue.remove();
            Node node = tuple.root;
            int x = tuple.x;
            int y = tuple.y;

            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }

            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }

            map.get(x).get(y).add(node.data);

            if (node.left != null) {
                queue.add(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                queue.add(new Tuple(node.right, x + 1, y + 1));
            }



        }
        List<List<Integer>> list = new ArrayList<>();

        for(TreeMap<Integer,PriorityQueue<Integer>> ys : map.values()){
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> xs : ys.values()){
                while (!xs.isEmpty()){
                    list.get(list.size()-1).add(xs.poll());
                }
            }
        }
        return list;

    }


    public static void main(String[] args) {
        VerticalOrderTraversal tree = new VerticalOrderTraversal();
        tree.root = new Node(3);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
        tree.root.right.right = new Node(7);
        tree.root.right.left = new Node(15);
        System.out.println(tree.verticalTraversal(tree.root));


    }

}
