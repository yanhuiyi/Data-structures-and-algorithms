package com.leetcode.problems;

public class Problems5 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        int start = 0, end = 0;

        for(int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public String longestPalindrome2(String s) {
        if(s == null || s.length() == 1) return s;

        int start = 0;
        int n = s.length();

        int low, high;
        int maxLength = 0;

        for(int i = 0; i < n; i++) {
            // Find the longest even length between i and i + 1
            low = i;
            high = i;
            while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                if(high - low + 1 > maxLength) {
                    maxLength = high - low + 1;
                    start = low;
                }
                low--;
                high++;
            }

            // Find the longest odd length between i and i + 1
            low = i;
            high = i + 1;
            while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                if(high - low + 1 > maxLength) {
                    maxLength = high - low + 1;
                    start = low;
                }
                low--;
                high++;
            }
        }
        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        System.out.println(new Problems5().longestPalindrome("bb"));
        System.out.println(new Problems5().longestPalindrome("babad"));
        System.out.println(new Problems5().longestPalindrome("cbbd"));

        System.out.println(new Problems5().longestPalindrome2("bb"));
        System.out.println(new Problems5().longestPalindrome2("babad"));
        System.out.println(new Problems5().longestPalindrome2("cbbd"));
    }
}
