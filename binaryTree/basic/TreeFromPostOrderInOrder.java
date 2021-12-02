package binaryTree.basic;

import java.util.HashMap;

public class TreeFromPostOrderInOrder {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    TreeFromPostOrderInOrder(int data) {
        root = new Node(data);
    }

    TreeFromPostOrderInOrder() {
        root = null;
    }

    public Node buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    public Node buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if (postStart > postEnd || inStart > inEnd)
            return null;
        Node root = new Node(postorder[postEnd]);
        int inIndex = map.get(root.data);
        int numLeft = inIndex - inStart;
        root.left = buildTree(postorder, postStart, postStart + numLeft - 1, inorder, inStart, inIndex - 1, map);
        root.right = buildTree(postorder, postStart + numLeft, postEnd - 1, inorder, inIndex + 1, inEnd, map);
        return root;
    }


    public static void main(String[] args) {
        TreeFromPostOrderInOrder tree = new TreeFromPostOrderInOrder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);

    }


}
