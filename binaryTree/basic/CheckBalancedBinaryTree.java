package binaryTree.basic;

public class CheckBalancedBinaryTree {

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

    CheckBalancedBinaryTree(int key) {
        root = new Node(key);
    }

    CheckBalancedBinaryTree() {
        root = null;
    }

    public boolean isBalanced(Node root) {
        if(balanced(root)==-1)
            return false;
        else
            return true;
    }

    public int balanced(Node root){
        if(root==null)
            return 0;
        int lh = balanced(root.left);
        if(lh==-1)
            return -1;
        int rh = balanced(root.right);
        if(rh==-1)
            return -1;

        if(Math.abs(lh-rh)>1)
            return -1;
        return 1+ Math.max(lh,rh);
    }


    public static void main(String[] args) {
        CheckBalancedBinaryTree tree = new CheckBalancedBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);
        System.out.println(tree.isBalanced(tree.root));
      

    }


}
