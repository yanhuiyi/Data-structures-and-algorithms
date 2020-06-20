package com.hankerrank.interviewpreparationkit.warmup;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : ar) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                count = count + entry.getValue() / 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(sockMerchant(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));
    }

}
