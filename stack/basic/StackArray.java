package stack.basic;


public class StackArray {
    static final int max = 100;
    int top;
    int[] arr = new int[max];

    StackArray() {
        top = -1;
    }

    public boolean isEmpty() {
        return top < 0;
    }


    boolean push(int val) {
        if (top >= (max - 1)) {
            System.out.println("overflow stack");
            return false;
        } else {
            arr[++top] = val;
            return true;
        }
    }

    int pop() {
        if (top >= 0) {
            return arr[top--];
        }
        System.out.println("underflow stack");
        return 0;
    }

    int peek() {
        if (top == 0) {
            System.out.println("underflow stack");
            return 0;
        } else return arr[top];
    }

    void printStack() {
        if (top > 0) {
            for (int i = 0; i <= top; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            System.out.println("underflow stack");
        }

    }

    public static void main(String[] args) {
        StackArray stack = new StackArray();
        if (stack.isEmpty())
            System.out.println("empty");
        else
            System.out.println("not empty");
        stack.push(2);
        stack.push(3);
        stack.push(5);
        System.out.println(stack.pop());
        stack.printStack();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }
}
