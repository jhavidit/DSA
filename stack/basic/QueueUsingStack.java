package stack.basic;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    /*
    Queue Using 2 stacks
    push time complexity - O(n)
    pop time complexity - O(1)
    */

    void pushEnqueHeavy(int x)
    {
        s2.push(x);
        s1.removeAllElements();
        for(int i =s2.size()-1;i>=0;i--)
        {
            s1.push(s2.get(i));
        }
    }


    int popEnqueueHeavy()
    {
        if(!s1.empty())
        {
            s2.remove(0);
            return s1.pop();
        }
        else
            return -1;

    }

    public static void main(String[] args){
        QueueUsingStack stack = new QueueUsingStack();
        stack.pushEnqueHeavy(2);
        stack.pushEnqueHeavy(5);
        stack.pushEnqueHeavy(6);
        System.out.println(stack.popEnqueueHeavy());
    }

}
