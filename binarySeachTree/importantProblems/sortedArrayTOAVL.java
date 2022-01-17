package binarySeachTree.importantProblems;

import binarySeachTree.basic.Floor;

public class sortedArrayTOAVL {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    sortedArrayTOAVL(int data) {
        root = new Node(data);
    }

    sortedArrayTOAVL() {
        root = null;
    }

    public Node sortedArrayToBST(int[] nums) {
        return AVLTree(nums, 0, nums.length - 1);

    }

    public Node AVLTree(int[] nums, int l, int r) {

        if (l <= r) {
            int mid = (l + r) / 2;
            Node node = new Node(nums[mid]);
            node.left = AVLTree(nums, l, mid - 1);
            node.right = AVLTree(nums, mid + 1, r);
            return node;
        }
        return null;
    }

    public static void main(String[] args) {
        sortedArrayTOAVL tree = new sortedArrayTOAVL();
        int[] arr = {5, 3, 4, 1, 3};
        System.out.println(tree.sortedArrayToBST(arr));
    }

}
