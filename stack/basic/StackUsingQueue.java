package stack.basic;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void pushPushCostly(int x){
        q2.add(x);
        while (!q1.isEmpty()){
            q2.add(q1.peek());
            q1.remove();
        }
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    void popPushCostly(){
        if(q1.isEmpty())
            System.out.println("underflow");
        else
            System.out.println("Popped : "+q1.remove());
    }

    void pushPopCostly(int x){
       q1.add(x);

    }

    void popPopCostly(){
       if(q1.isEmpty())
           System.out.println("underflow");
       else {
           while (true)
           {
               int a = q1.remove();
               if(q1.isEmpty()) {
                   System.out.println("Popped : "+a);
                   break;
               }
               else
                   q2.add(a);
           }
           q1 = q2;
           q2 = new LinkedList<>();

       }
    }

    public static void main(String[] args){
        StackUsingQueue stack = new StackUsingQueue();
        stack.pushPopCostly(5);
        stack.pushPopCostly(6);
        stack.pushPopCostly(8);
        System.out.println(stack.q1);
        stack.popPopCostly();
        System.out.println(stack.q1);

        stack.pushPushCostly (6);
        stack.pushPushCostly(8);
        System.out.println(stack.q1);
        stack.popPushCostly();
        System.out.println(stack.q1);
    }

}
