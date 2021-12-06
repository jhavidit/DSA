package binarySeachTree.basic;

public class Ceil {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    Ceil(int data) {
        root = new Node(data);
    }

    Ceil() {
        root = null;
    }

    public int findCeil(Node tree, int key) {
        int ceil = -1;
        while (tree != null) {
            if (tree.data == key) {
                ceil = key;
                return ceil;
            }
            if (tree.data < key) {
                tree = tree.right;
            } else {
                ceil = tree.data;
                tree = tree.left;
            }

        }
        return ceil;
    }


    public static void main(String[] args) {
        Ceil tree = new Ceil();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);
        System.out.println(tree.findCeil(tree.root, 3));
    }

}
