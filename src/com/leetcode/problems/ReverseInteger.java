package com.leetcode.problems;

public class ReverseInteger {
    public static int reverse(int x) {
        int rev = 0;
        while(x != 0) {
            int pop = x % 10;
            x /= 10;
            if(x > Integer.MAX_VALUE / 10 || (x == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if(x < Integer.MIN_VALUE / 10 || (x == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

            rev = rev * 10 + pop;
        }


        return rev;
    }

    public static void main(String [] args) {
        System.out.println(reverse(-120));
    }
}
