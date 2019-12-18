package com.leetcode.problems;

public class Problems14 {

    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;

        if(len == 0) return "";

        String res = new String();

        for(int j = 0; j < strs[0].length(); j++) {
            char cur = strs[0].charAt(j);

            for(int i = 1; i < len; i++) {
                char next = strs[i].charAt(j);
                if(j >= strs[i].length() || next != cur) {
                   return res;
                }
            }
            res += Character.toString(cur);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Problems14().longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
        System.out.println(new Problems14().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(new Problems14().longestCommonPrefix(new String[]{"c", "c"}));
    }
}
