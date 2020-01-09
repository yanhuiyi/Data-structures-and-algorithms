package com.leetcode.problems;

import java.util.Stack;

public class Problems150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if ("+-*/".indexOf(s) == -1) {
                stack.push(Integer.valueOf(s));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num2 / num1);
                        break;
                }
            }
        }

        return stack.isEmpty() ? 0 : stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(new Problems150().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(new Problems150().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
