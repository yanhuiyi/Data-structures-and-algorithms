package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problems315 {

    public static List<Integer> countSmaller(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int count = 0;
            map.put(i, count);
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[i]) {
                    map.put(i, ++count);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countSmaller(new int[]{5, 2, 6, 1}));
    }
}
