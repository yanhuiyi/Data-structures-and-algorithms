package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problems22 {

//    public static boolean isMatch(String input) {
//        char[] parentheses = input.toCharArray();
//        Stack<Character> stack = new Stack<>();
//
//        if(parentheses.length == 0) {
//            return true;
//        }
//
//        for(char parenthesis : parentheses) {
//            if(parenthesis == '(') {
//                stack.push(parenthesis);
//            } else {
//                Character ch = stack.pop();
//                if(ch.charValue() != '(') {
//                    return false;
//                }
//            }
//        }
//
//      return  stack.size() == 0;
//    }
//
//    public static boolean valid(char[] current) {
//        int balance = 0;
//        for(char c: current) {
//            if(c == '(') balance++;
//            else balance--;
//            if(balance < 0) return false;
//        }
//        return balance == 0;
//    }
//
//    public static void generateAll(char[] current, int pos, List<String> result) {
//        if(pos == current.length) {
//            if(valid(current)) result.add(new String(current));
//        } else {
//            current[pos] = '(';
//            generateAll(current, pos + 1, result);
//            current[pos] = ')';
//            generateAll(current, pos + 1, result);
//        }
//    }
//
//    public static List<String> generateParenthesis(int n) {
//        List<String> combinations = new ArrayList<>();
//        generateAll(new char[2 * n], 0, combinations);
//        return combinations;
//    }

    public static void main(String[] args) {
      System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n == 0) return list;
        String combination = "";

        helper(n, n, combination, list);

        return list;
    }

    public static void helper(int left, int right, String combination, List<String> list) {
        if(right < left)
            return;

        if(left == 0 && right == 0)
            list.add(combination);
        if(left > 0)
            helper(left - 1, right, combination + "(", list);
        if(right > 0)
            helper(left, right -1, combination + ")", list);

    }
}
