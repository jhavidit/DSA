package binaryTree.basic;

public class MaximumPathSum {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    MaximumPathSum(int data) {
        root = new Node(data);
    }

    MaximumPathSum() {
        root = null;
    }

    int max = Integer.MIN_VALUE;

    public int getMaxPathSum(Node root) {
        maxPathSum(root);
        return max;
    }

    public int maxPathSum(Node root) {
        if (root == null)
            return 0;
        int lh = Math.max(0, maxPathSum(root.left));
        int rh = Math.max(0, maxPathSum(root.right));
        max = Math.max(max, root.data + lh + rh);
        return root.data + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        MaximumPathSum tree = new MaximumPathSum();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);
        System.out.println(tree.getMaxPathSum(tree.root));

    }


}
