package stack.basic;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingSingleQueue {
    int count;
    Queue<Integer> queue = new LinkedList<>();

    void push(int x) {
        if (count == 0) {
            queue.add(x);
            count++;
        } else {
            queue.add(x);
            for (int i = 0; i < count; i++) {
                queue.add(queue.remove());
            }
            count++;
        }
    }

    void pop(){
        if(count==0){
            System.out.println("Stack Underflow");
        }else {
            System.out.println("Popped : "+queue.remove());
            count--;
        }
    }

    public static void main(String[] args){
        StackUsingSingleQueue stack = new StackUsingSingleQueue();
        stack.push(5);
        stack.push(8);
        stack.push(12);
        System.out.println(stack.queue);
        stack.pop();
        System.out.println(stack.queue);
        stack.push(6);
        System.out.println(stack.queue);
        stack.pop();
        System.out.println(stack.queue);
    }


}
