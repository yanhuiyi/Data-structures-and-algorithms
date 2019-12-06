package com.leetcode.problems;

public class Problems29 {
    public int divide(int dividend, int divisor) {
        int sign = dividend < 0 || divisor < 0 ? -1 : 1;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int left = 0, right = dividend;

        while(left < right) {
            int mid = (right - left) / 2 + left;

            if(mid * divisor < dividend) left = mid + 1;
            else right = mid;
        }

        return (right - 1) * sign;

    }

    int divide2(int dividend, int divisor) {
        int m = Math.abs(dividend), n = Math.abs(divisor), res = 0;

        if(m < n) return 0;

        while (m >= n) {
            int t = n, p = 1;

            while (m > (t << 1)) {
                t <<= 1;
                p <<= 1;
            }

            res += p;
            m -= t;
        }

        if((dividend < 0 ) ^ (divisor < 0 )) res = -res;
        return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : res;
    }

    int divide3(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        int sign = dividend < 0 ^ divisor < 0 ? -1 : 1;

        long m = Math.abs((long)dividend);
        long n = Math.abs((long)divisor);

        if(n == 1) return (int)(m * sign);

        int quotient = 0;

        while(m >= n) {
            m -= n;
            ++quotient;
        }

        return sign * quotient;
    }

    int divide4(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;

        long m = Math.abs((long)dividend), n = Math.abs((long)divisor), res = 0;

        int sign = (dividend < 0 ^ divisor < 0) ? -1 : 1;

        if(n == 1) return (int)m * sign;

        while(m >= n) {
            long t = n, p = 1;
            while (m >= (t << 1)) {
                t <<= 1;
                p <<= 1;
            }
            res += p;
            m -= t;
        }

        return (int)res * sign;
    }

    public static void main(String[] args) {
//        System.out.println(new Problems29().divide2(10, 3));
        System.out.println(new Problems29().divide4(-2147483648, 2));

        System.out.println(new Problems29().divide3(-2147483648, 2));
//        System.out.println(new Problems29().divide3(7, -3));
//
//        System.out.println(Math.abs(-2147483648));
//        System.out.println(Math.abs((long)Math.pow(2, 31)));
//        System.out.println(Math.abs((long)Math.pow(2, 32)));

    }
}
