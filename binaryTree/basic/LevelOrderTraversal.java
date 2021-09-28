package binaryTree.basic;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    LevelOrderTraversal(int data) {
        root = new Node(data);
    }

    LevelOrderTraversal() {
        root = null;
    }

    void levelOrderTraversal(Node node){
        if(root==null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Node temp = queue.remove();
                System.out.println(temp.data);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
    }

    public static void main(String[] args){
        LevelOrderTraversal tree = new LevelOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);
        tree.root.left.left = new Node(6);
        tree.root.left.right = new Node(8);
        tree.levelOrderTraversal(tree.root);

    }

}
