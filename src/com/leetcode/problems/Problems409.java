package com.leetcode.problems;

public class Problems409 {
    public int longestPalindrome(String s) {
        int[] charMap = new int[128];
        int maxLength = 0;
        int flag = 0;

        for (char c : s.toCharArray()) {
            charMap[c] = charMap[c] + 1;
        }

        for (int i : charMap) {
            if(i > 0) {
                if(i % 2 == 0) {
                    maxLength += i;
                } else {
                    maxLength += (i - 1);
                    flag = 1;
                }

            }
        }

        return maxLength + flag;
    }

    public static void main(String[] args) {
        System.out.println(new Problems409().longestPalindrome("abbbccc"));
    }
}
