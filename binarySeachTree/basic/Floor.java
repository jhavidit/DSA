package binarySeachTree.basic;

public class Floor {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    Floor(int data) {
        root = new Node(data);
    }

    Floor() {
        root = null;
    }

    public int findFloor(Node root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.data == key) {
                floor = key;
                return floor;
            }
            if (root.data > key) {
                root = root.left;
            } else {
                floor = root.data;
                root = root.right;
            }

        }
        return floor;
    }


    public static void main(String[] args) {
        Floor tree = new Floor();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);
        System.out.println(tree.findFloor(tree.root, 4));
    }

}
