package stack.standardProblems;


import java.util.Stack;

public class InfixToPostfix {


    static int precedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '/', '*' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    public static String infixToPostfix(String str) {
        StringBuilder s = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (Character.isLetterOrDigit(ch)) {
                s.append(ch);
            } else if (stack.isEmpty() || precedence(ch) > precedence(stack.peek())) {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    s.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    s.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                s.append(stack.pop());
            }
        }

        return s.toString();
    }

    public static void main(String[] args) {
        String str = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(str));
    }

}
