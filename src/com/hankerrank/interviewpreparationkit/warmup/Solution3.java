package com.hankerrank.interviewpreparationkit.warmup;

public class Solution3 {

    static int jumpingOnClouds(int[] c) {
        int jump_numbers = 0;
        int i = 0;
        while (i < c.length - 1) {
            if(i + 2 < c.length && c[i + 2] == 0) {
                i = i + 2;
                jump_numbers++;
            } else {
                i++;
                jump_numbers++;
            }
        }
        return jump_numbers;
    }

    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0}));
        System.out.println(jumpingOnClouds(new int[]{0, 0, 0, 0, 1, 0}));
    }
}
