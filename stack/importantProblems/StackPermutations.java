package stack.importantProblems;

import java.util.Stack;

public class StackPermutations {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pushedIndex = 0;
        for (int j : popped) {
            while (!stack.contains(j)) {
                stack.push(pushed[pushedIndex]);
                pushedIndex++;
            }
            if (stack.peek() != j) {
                return false;
            } else
                stack.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(pushed, popped));
    }

}
