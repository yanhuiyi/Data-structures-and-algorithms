package com.leetcode.problems;

public class Problems125 {
    public boolean isPalindrome(String s) {
        if(s.trim().length() == 0) return true;

        String input = s.toLowerCase();
        StringBuilder sb = new StringBuilder();

        for(char c : input.toCharArray()) {
            if(Character.isLetter(c) || Character.isDigit(c) )
                sb.append(c);
        }

        input = sb.toString();

        int m = input.length();

        for(int i = 0, j = m - 1; i < j; i++, j--)
            if(input.charAt(i) != input.charAt(j))
                return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problems125().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
