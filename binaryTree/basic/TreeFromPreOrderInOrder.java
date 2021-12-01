package binaryTree.basic;

import java.util.HashMap;

public class TreeFromPreOrderInOrder {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    TreeFromPreOrderInOrder(int data) {
        root = new Node(data);
    }

    TreeFromPreOrderInOrder() {
        root = null;
    }

    public Node buildTree(int[] inorder, int[] preorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    public Node buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        Node root = new Node(preorder[preStart]);
        int inIndex = map.get(root.data);
        int numLeft = inIndex - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + numLeft, inorder, inStart, inIndex - 1, map);
        root.right = buildTree(preorder, preStart + numLeft + 1, preEnd, inorder, inIndex + 1, inEnd, map);
        return root;
    }


    public static void main(String[] args) {
        TreeFromPreOrderInOrder tree = new TreeFromPreOrderInOrder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);

    }

}
