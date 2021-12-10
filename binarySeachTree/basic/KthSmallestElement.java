package binarySeachTree.basic;

public class KthSmallestElement {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode root;

    KthSmallestElement(int val) {
        root = new TreeNode(val);
    }

    KthSmallestElement() {
        root = null;
    }

    int c = 0;
    int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        kthSmallestNode(root, k);
        return ans;
    }


    public void kthSmallestNode(TreeNode root, int k) {
        if (root != null) {
            kthSmallestNode(root.left, k);
            c++;
            if (c == k)
                ans = root.val;
            kthSmallestNode(root.right, k);

        }
    }


    public static void main(String[] args) {
        KthSmallestElement tree = new KthSmallestElement();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.right.right = new TreeNode(4);

    }

}
