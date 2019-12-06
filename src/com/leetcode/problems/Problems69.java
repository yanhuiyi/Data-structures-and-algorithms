package com.leetcode.problems;

public class Problems69 {

    public int mySqrt(int x) {

        if(x == 1) return 1;

//        int i = 1;
//        while(i * i <= x) {
//            i++;
//        }

        int l = 0, r = x;

        while(l < r) {
            int mid = (r - l) / 2 + l;
            if(x / mid >= mid) l = mid + 1;
            else r = mid;
        }

        return r - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Problems69().mySqrt(2147395600));
        System.out.println(new Problems69().mySqrt(9));
        System.out.println(new Problems69().mySqrt(1000));
//        System.out.println(Integer.MAX_VALUE);
    }
}
