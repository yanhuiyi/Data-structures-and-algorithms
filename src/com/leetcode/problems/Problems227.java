package com.leetcode.problems;

import java.util.Stack;

public class Problems227 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int num = 0;
        int op = '+';

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ("+-/*".indexOf(c) >= 0 || i == s.length() - 1) {
                switch (op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        result -= stack.peek();
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        result -= stack.peek();
                        stack.push(stack.pop() / num);
                        break;
                }

                result += stack.peek();
                num = 0;
                op = c;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problems227().calculate(" 3+5 / 2 "));
    }
}
