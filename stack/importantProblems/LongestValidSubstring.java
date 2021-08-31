package stack.importantProblems;

import java.util.Stack;

public class LongestValidSubstring {

    public static int longestValidSubstring(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty())
                    stack.pop();
                if (!stack.isEmpty()) {
                    max = Math.max(max, i - stack.peek());
                } else
                    stack.push(i);
            }
        }
        return max;
    }

    public static void main(String[] args){
        String str = "()(())(";
        System.out.println(longestValidSubstring(str));
    }

}
