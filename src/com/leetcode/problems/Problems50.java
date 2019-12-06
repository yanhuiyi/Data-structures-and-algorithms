package com.leetcode.problems;

public class Problems50 {
    public double myPow(double x, int n) {
        double res = 1;

        int p = 0;

        int m = Math.abs(n);

        while(p < m) {
            res = n > 0 ? res * x : res / x;
            p++;
        }

        return res;
    }

    public double myPow2(double x, int n) {

        double res = 1.0;

        for(int i = n; i != 0; i /= 2) {
            if(i % 2 != 0)
                res *= x;
            x *= x;
        }

        return n < 0 ? 1 / res : res;
    }

    public static void main(String[] args) {

//        System.out.println(new Problems50().myPow(0.00001, 2147483647));

        System.out.println(new Problems50().myPow2(2.00000, 10));
    }
}
