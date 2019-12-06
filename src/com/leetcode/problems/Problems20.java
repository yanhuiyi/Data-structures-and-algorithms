package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problems20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = new HashMap<>();

        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        int index = 0, len = s.length();

        while(index < len) {
            char cur = s.charAt(index);
            if(cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
            } else if(!stack.empty() && map.get(stack.peek()) == cur) {
                stack.pop();
            } else {
                return false;
            }

            ++index;
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(new Problems20().isValid("]"));
    }
}
