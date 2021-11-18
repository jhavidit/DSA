package binaryTree.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SymmetricTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    SymmetricTree(int data) {
        root = new Node(data);
    }

    SymmetricTree() {
        root = null;
    }

    List<List<Integer>> list = new ArrayList<>();

    boolean check = true;

    public boolean symmetric(Node root) {
        checkSymmetric(root.left, root.right);
        return check;
    }

    public void checkSymmetric(Node p, Node q) {
        if (p == null && q == null)
            return;
        if (p == null || q == null) {
            check = false;
            return;
        }
        if (p.data != q.data) {
            check = false;
            return;
        }
        checkSymmetric(p.left, q.right);
        checkSymmetric(p.right, q.left);
    }


    public static void main(String[] args) {
        SymmetricTree tree = new SymmetricTree();
        tree.root = new Node(3);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
        tree.root.right.right = new Node(7);
        tree.root.right.left = new Node(15);
        System.out.println(tree.symmetric(tree.root));


    }

}
