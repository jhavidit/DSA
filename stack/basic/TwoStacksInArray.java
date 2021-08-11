package stack.basic;

public class TwoStacksInArray {
    int size;
    int top1, top2;
    int[] arr = new int[100];

    TwoStacksInArray() {
        size = 100;
        top1 = -1;
        top2 = size;
    }

    public static void main(String[] args)
    {
        TwoStacksInArray st = new TwoStacksInArray();
        Stacks stack = new Stacks();
        stack.push1(5,st);
        stack.push2(12,st);
        stack.push1(8,st);
        stack.push1(3,st);
        stack.push2(1,st);
        System.out.println(stack.pop1(st));
        System.out.println(stack.pop2(st));
        System.out.println(stack.pop1(st));
        System.out.println(stack.pop2(st));
        System.out.println(stack.pop1(st));
        System.out.println(stack.pop2(st));
    }
}


    class Stacks {
        //Function to push an integer into the stack1.
        void push1(int x, TwoStacksInArray sq) {
            if (sq.top1 < sq.top2 - 1)
                sq.arr[++sq.top1] = x;
            else
                System.out.println("Overflow");
        }


        //Function to push an integer into the stack2.
        void push2(int x, TwoStacksInArray sq) {
            if (sq.top2 > sq.top1 + 1)
                sq.arr[--sq.top2] = x;
            else
                System.out.println("Overflow");
        }


        //Function to remove an element from top of the stack1.
        int pop1(TwoStacksInArray sq) {
            if (sq.top1 == -1) {
                System.out.println("underflow");
                return -1;
            } else {
                return sq.arr[sq.top1--];
            }
        }

        //Function to remove an element from top of the stack2.
        int pop2(TwoStacksInArray sq) {
            if (sq.top2 == sq.size) {
                System.out.println("underflow");
                return -1;
            } else {
                return sq.arr[sq.top2++];
            }
        }
    }

