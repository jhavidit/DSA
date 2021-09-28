package binaryTree.basic;

import java.util.ArrayList;

public class NodesAtKDistance {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    NodesAtKDistance(int data) {
        root = new NodesAtKDistance.Node(data);
    }

    NodesAtKDistance() {
        root = null;
    }

    void Kdistance(Node node, int k) {
        if (node == null) {
            return;
        } else if (k == 0) {
            System.out.println(node.data);
        } else {
            Kdistance(node.left, k - 1);
            Kdistance(node.right, k - 1);
        }


    }

    public static void main(String[] args) {
        NodesAtKDistance tree = new NodesAtKDistance();
        tree.root = new NodesAtKDistance.Node(1);
        tree.root.left = new NodesAtKDistance.Node(2);
        tree.root.right = new NodesAtKDistance.Node(3);
        tree.root.right.right = new NodesAtKDistance.Node(4);
        tree.root.left.left = new Node(6);
        tree.root.left.right = new Node(8);
        tree.Kdistance(tree.root, 2);

    }

}
