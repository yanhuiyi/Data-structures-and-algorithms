package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problems17 {

    String[] chars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null || digits.length() == 0) return result;
        backtracking(result, new StringBuilder(), digits, 0);
        return result;
    }

    public void backtracking(List<String> result, StringBuilder sb, String digits, int index) {
        if(index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String str = chars[digits.charAt(index) - '0'];
        for(char c : str.toCharArray()) {
            sb.append(c);
            backtracking(result, sb, digits, index + 1);
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problems17().letterCombinations("23"));
    }
}
