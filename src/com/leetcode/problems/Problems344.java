package com.leetcode.problems;

import com.huwawei.interview.Problems1;

public class Problems344 {
    public void reverseString(char[] s) {
        if(s == null || s.length < 2) return;
        int i = 0, j = s.length - 1;

        while (i < s.length / 2) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        new Problems344().reverseString(s);
        System.out.println(s);
        char[] s2 = {'H','a','n','n','a','h'};
        new Problems344().reverseString(s2);
        System.out.println(s2);
    }
}
