package stack.standardProblems;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    public int[] nextSmallerElement(int[] arr) {
        int[] output = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    output[stack.pop()] = arr[i];
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            output[stack.pop()] = -1;
        }

        return output;
    }

    public static void main(String[] args) {
        NextSmallerElement obj = new NextSmallerElement();
        int[] arr = {13, 7, 6, 12};
        System.out.println(Arrays.toString(obj.nextSmallerElement(arr)));

    }

}
