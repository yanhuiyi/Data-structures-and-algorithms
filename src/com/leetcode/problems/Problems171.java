package com.leetcode.problems;

public class Problems171 {
    public int titleToNumber(String s) {

        if(s.length() == 0) return 0;
//
//        Map<Character, Integer> dict = new HashMap<>();
//
//        for(int i = 0; i < 26; i++) {
//            dict.put((char) (65 + i), i + 1);
//        }
//
//        int ret = 0;
//        int m = s.length();
//
//        for(int i = 0; i < m; i++) {
//
//            ret += Math.pow(26, m - i - 1) * dict.get(s.charAt(i));
//        }

        int tmp = 1;
        int ret = 0;
        int m = s.length();

        for(int i = m; i >= 1; --i) {
            ret += (s.charAt(i - 1) - 'A' + 1) * tmp;
            tmp *= 26;
        }


        return ret;
    }
    public  static void main(String[] args) {
        System.out.println(new Problems171().titleToNumber("AB"));
    }
}
