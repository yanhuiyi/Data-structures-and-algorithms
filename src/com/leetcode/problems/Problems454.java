package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Problems454 {


    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for(int a : A)
            for(int b : B)
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);


        for(int c : C)
            for(int d : D) {
                int target = c + d;
                if(map.containsKey(-target))
                    res += map.get(-target);
            }

        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[] {1, 2};
        int[] B = new int[] {-2, -1 };
        int[] C = new int[] {-1, 2};
        int[] D = new int[] {0, 2};



        System.out.println(new Problems454().fourSumCount(A, B, C, D));
    }
}
