package com.leetcode.problems;

public class Problems557 {

    public String reverseWords(String s) {
        if(s == null || s.length() < 2) return s;

        int i = 0, j = 0;
        char[] c = s.toCharArray();
        int n = s.length();

        while(i < n) {
            while(j < n && c[j] != ' ') ++j;
            reverse(c, i, j - 1);
            i = ++j;
        }

        return String.valueOf(c);
    }

    private void reverse(char[] s, int i, int j) {
        while(i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
    public static void main(String[] args) {
        System.out.println(new Problems557().reverseWords("Let's take LeetCode contest"));
    }
}
