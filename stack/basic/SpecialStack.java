package stack.basic;

import java.util.Stack;

public class SpecialStack extends Stack<Integer> {

    Stack<Integer> min = new Stack<>();

    /*
    Space optimised solution
    Time Complexity - O(1) for push,peek,pop,getMin,empty
    Space Complexity - O(n) Worst Time Complexity would be better most times

    Maintain a stack that at the top value will contains the minimum value
    Im Space Optimised solution we push to min stack only if the new value is smaller than prev
    In Non Space Optimised solution  we push to min stack everytime we push with the minimum value here space complexity will be O(n)

    In this we inherit all the properties of stack and add a new property getMin() that will get minimum value in 0(1) time complexity
     */
    void push(int x) {
        if (isEmpty()) {
            super.push(x);
            min.push(x);
        } else {
            super.push(x);
            if (x < min.peek())
                min.push(x);
        }
    }

    public Integer pop() {
        int x = super.pop();
        int y = min.pop();
        if (x != y) {
            min.push(y);
        }
        return x;
    }

    void getMin() {
        System.out.println(min.peek());
    }

    public static void main(String[] args) {
        SpecialStack stack = new SpecialStack();
        stack.push(4);
        stack.push(6);
        stack.push(8);
        System.out.println(stack.pop());
        stack.push(-2);
        stack.getMin();
    }


}


