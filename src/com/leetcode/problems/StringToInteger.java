package com.leetcode.problems;

public class StringToInteger {
    public static int myAtoi(String str) {
        str = str.trim();

        char[] chars = str.toCharArray();

        int len = chars.length;

        char startChar = chars[0];

        if(!(startChar >= '0' && startChar <= '9') && startChar != '-') {
            return 0;
        }

        int i = 0;
        int ret = 0;
        char cur = 0;
        int flag = 1;

        while(i < len) {
            cur = chars[i];

            if(cur == '-') {
                ++i;
                flag = -1;
                continue;
            }

            if(!(cur >= '0' && cur <= '9')) {
                break;
            }

            int pop = flag * Character.getNumericValue(cur);

            if((ret > Integer.MAX_VALUE / 10) || (ret == Integer.MAX_VALUE / 10 && pop > 7 )) return Integer.MAX_VALUE;

            if((ret < Integer.MIN_VALUE / 10) || (ret == Integer.MIN_VALUE / 10 && pop < -8 )) return Integer.MIN_VALUE;

            ret = ret * 10 + pop;

            ++i;
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("-24"));
    }
}
