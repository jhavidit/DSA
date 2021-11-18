package binaryTree.basic;

public class DiameterOfBinaryTree {

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

    DiameterOfBinaryTree(int key) {
        root = new Node(key);
    }

    DiameterOfBinaryTree() {
        root = null;
    }
    int max = 0;


    int height(Node node) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        max = Math.max(max, lh + rh);
        return Math.max(lh, rh) + 1;
    }


    public int diameter(Node root) {
     height(root);
     return max;

    }

    public static void main(String[] args) {
        DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);
        tree.root.left.left = new Node(5);
        System.out.println(tree.diameter(tree.root));


    }


}
