package com.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class Problems202 {
    public boolean isHappy(int n) {
        int num = n;
        int sum = 0;
        int mod = n;

        Set<Integer> set = new HashSet<>();

        while(sum != 1) {
            sum = 0;

            while(num > 0) {
                mod = num % 10;
                num = num / 10;
                sum += mod * mod;
            }
            if(set.contains(sum)) return false;

            set.add(sum);
            num = sum;
        }

        return sum == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Problems202().isHappy(19));

        int num = 100;
        int mod;
        int sum  = 0;

        while(num > 0) {
           mod = num % 10;
            num = num / 10;
            sum += mod * mod;
        }

        System.out.println( sum);
    }
}
