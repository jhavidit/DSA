package stack.standardProblems;

import java.util.Stack;

public class EvaluationOfPostfixExpression extends InfixToPostfix {


    public static int calculate(int a, int b, char ch) {
        switch (ch) {
            case '+': {
                return b + a;
            }
            case '-': {
                return b - a;
            }
            case '*': {
                return b * a;
            }
            case '/': {
                return b / a;
            }

        }
        return -1;
    }


    public static int evaluatePostfix(String str) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch));
            } else {
                stack.push(calculate(stack.pop(), stack.pop(), ch));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String str = "2+3";
        System.out.println(evaluatePostfix(infixToPostfix(str)));
    }

}
