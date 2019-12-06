package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Problems169 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet())  {
            if(entry.getValue() > nums.length / 2)
                return entry.getKey();
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Problems169().majorityElement(new int[]{3, 2, 3}));
    }
}
