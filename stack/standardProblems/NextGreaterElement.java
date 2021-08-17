package stack.standardProblems;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static long[] nextGreaterElement(long[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        long[] nge = new long[n];
        if (n > 0)
            stack.push(0);
        for (int i = 1; i < n; i++) {
            if (arr[stack.peek()] >= arr[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                    nge[stack.pop()] = arr[i];
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            nge[stack.pop()] = -1;
        }

        return nge;
    }

    public static void main(String[] args) {
        long[] arr = {6,8,0,1,3};
        System.out.println(Arrays.toString(nextGreaterElement(arr, arr.length)));
    }

}
