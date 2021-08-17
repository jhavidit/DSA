package stack.standardProblems;

import java.util.Stack;

public class ExpressionContainsRetundantParanthesis {

    public static boolean checkParanthesis(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    return false;
                }
                stack.push(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    return false;
                } else {
                    while (stack.isEmpty() ||  stack.peek() != '(') {
                        stack.pop();
                    }
                   stack.pop();
                }
            } else if (Character.isLetterOrDigit(ch)) {
                s.append(ch);
            } else {
                stack.push(ch);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "((a+b))";
        System.out.println(checkParanthesis(str));
    }

}
