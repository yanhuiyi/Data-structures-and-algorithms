package com.leetcode.problems;

public class Problems172 {
    public int trailingZeroes(int n) {
        int res = 0;

        while(n > 0) {
            res += n / 5;
            n /= 5;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Problems172().trailingZeroes(15));
    }
}
