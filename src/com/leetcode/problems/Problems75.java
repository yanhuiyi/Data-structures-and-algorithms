package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Problems75 {

    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;

        Map<Integer,Integer> map = new HashMap<>();

        int redCount = 0, whiteCount = 0, blueCount = 0;

        for(int i : nums) {
            if(i == 0 ) ++redCount;
            if(i == 1 ) ++whiteCount;
            if(i == 2 ) ++blueCount;
        }

        for(int i = 0; i < redCount; i++)
            nums[i] = 0;

        for(int i = 0; i < whiteCount; i++)
            nums[redCount + i] = 1;

        for(int i = 0; i < blueCount; i++)
            nums[redCount + whiteCount + i] = 2;
    }

    public static void main(String[] args) {
        int[] matrix = new int[]{0, 1, 0};
        new Problems75().sortColors(matrix);
    }
}
