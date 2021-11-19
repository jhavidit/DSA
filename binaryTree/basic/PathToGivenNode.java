package binaryTree.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathToGivenNode {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    PathToGivenNode(int data) {
        root = new Node(data);
    }

    PathToGivenNode() {
        root = null;
    }

    List<Integer> pathToNode(Node root, int num) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        getPath(root, list, num);
        return list;
    }

    private boolean getPath(Node root, ArrayList<Integer> list, int num) {
        if (root == null)
            return false;
        list.add(root.data);
        if (root.data == num)
            return true;
       if(getPath(root.left,list,num)||getPath(root.right,list,num))
           return true;
       list.remove(list.size()-1);
       return false;
    }


    public static void main(String[] args) {
        PathToGivenNode tree = new PathToGivenNode();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);
        System.out.println(tree.pathToNode(tree.root,4));

    }

}
