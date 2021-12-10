package binarySeachTree.basic;

public class Delete {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    Delete(int data) {
        root = new Node(data);
    }

    Delete() {
        root = null;
    }

    public Node deleteNode(Node root, int key) {
        if (root == null)
            return null;
        if (root.data == key)
            return helper(root);
        Node temp = root;
        while (temp != null) {
            if (key < temp.data) {
                if (temp.left != null && temp.left.data == key) {
                    temp.left = helper(temp.left);
                    break;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right != null && temp.right.data == key) {
                    temp.right = helper(temp.right);
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }

        return root;
    }

    private Node helper(Node root) {
        if (root.left == null)
            return root.right;
        else if (root.right == null)
            return root.left;
        else {
            Node rightChild = root.right;
            Node lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }

    }

    private Node findLastRight(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }


    public static void main(String[] args) {
        Delete tree = new Delete();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);
        System.out.println(tree.deleteNode(tree.root, 4));

    }


}
