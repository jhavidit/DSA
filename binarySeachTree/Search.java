package binarySeachTree;


public class Search {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    Search(int data) {
        root = new Node(data);
    }

    Search() {
        root = null;
    }

    public Node searchBST(Node root, int val) {
        if (root == null)
            return null;
        if (val == root.data)
            return root;
        else if (val > root.data)
            return searchBST(root.right, val);
        else
            return searchBST(root.left, val);

    }

    public static void main(String[] args) {
        Search tree = new Search();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);
        System.out.println(tree.searchBST(tree.root, 5));


    }
}
