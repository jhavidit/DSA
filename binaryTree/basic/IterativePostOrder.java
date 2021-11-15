package binaryTree.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrder {

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

    IterativePostOrder(int key) {
        root = new Node(key);
    }

    IterativePostOrder() {
        root = null;
    }


    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(curr!=null||!stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            else {
                Node temp = stack.peek().right;
                if(temp!=null){
                    curr = temp;
                }
                else {
                    temp = stack.pop();
                    list.add(temp.data);
                    while(!stack.isEmpty()&&stack.peek().right==temp){
                        temp = stack.pop();
                        list.add(temp.data);
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        IterativePostOrder tree = new IterativePostOrder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(4);
        System.out.println(tree.postorder(tree.root));


    }

}
