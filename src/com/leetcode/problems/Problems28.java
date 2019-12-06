package com.leetcode.problems;

public class Problems28 {

    public int strStr(String haystack, String needle) {
       int m = haystack.length();
       int n = needle.length();

       if(n == 0) return 0;
       if(m < n) return -1;

       for(int i = 0; i <= m - n; i++) {
           int j = 0;

           for (; j < n; j++) {
               if (haystack.charAt(i + j) != needle.charAt(j))
                   break;
           }

           if(j == n)
               return i;
       }
       return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Problems28().strStr("hello", "ll"));
        System.out.println(new Problems28().strStr("mississippi", "issipi"));
    }

}