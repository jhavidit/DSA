package binaryTree.basic;

public class SameTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    SameTree(int data) {
        root = new Node(data);
    }

    SameTree() {
        root = null;
    }

    boolean check = true;
    public void checkSame(Node p,Node q){

        if(p==null&&q==null)
            return;
        if(p == null || q == null){
            check = false;
            return;
        }

        if(p.data!=q.data)
            check = false;
        isSameTree(p.left,q.left);
        isSameTree(p.right,q.right);

    }

    public boolean isSameTree(Node p, Node q) {
        checkSame(p,q);
        return check;
    }


    public static void main(String[] args) {
        SameTree tree1 = new SameTree();
        tree1.root = new Node(1);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);
        tree1.root.right.right = new Node(4);
        SameTree tree2 = new SameTree();
        tree2.root = new Node(1);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(3);
        tree2.root.right.right = new Node(4);
        System.out.println(tree1.isSameTree(tree1.root,tree2.root));


    }

}
