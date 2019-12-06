package com.leetcode.problems;

import java.util.Arrays;

public class Problems41 {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;

        int len = nums.length;
        int i = 0;

        Arrays.sort(nums);

        if(nums[len - 1] < 0) return 1;
        if(nums[0] > 1) return 1;

        for(; i < len - 1; i++) {
            if(Math.abs(nums[i + 1]) - Math.abs(nums[i]) == 0 && nums[i + 1] != nums[i] && Math.abs(nums[i]) != 1) {
                return 1;
            } else if((Math.abs(nums[i + 1]) - Math.abs(nums[i]) == 1 || Math.abs(nums[i]) - Math.abs(nums[i + 1]) == 1 ) && (nums[i + 1] > 0 && nums[i] < 0) && nums[i+1] != 1) {
                return 1;
            } else if(Math.abs(nums[i + 1]) - Math.abs(nums[i]) > 1 || Math.abs(nums[i]) - Math.abs(nums[i + 1]) > 1) {
                break;
            }
        }

        int ans = nums[i] > nums[i + 1] ? nums[i] : nums[i + 1];

        if(ans < 1) {
            return 1;
        } else {
            return ans + 1;
        }
    }

    public int firstMissingPositive2(int[] nums) {
        if(nums == null || nums.length == 0) return 1;

        int len = nums.length;
        int i = 0;
        int res = 0;

        Arrays.sort(nums);

        while(i < len && nums[i] <= 0) i++;

        for(; i < len; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            if(nums[i] - res != 1)
                return res + 1;
            else
                res = nums[i];
        }

        return res + 1;
    }


    public static void main(String[] args) {
        System.out.println(new Problems41().firstMissingPositive2(new int[]{1, 2, 0}));
//        System.out.println(new Problems41().firstMissingPositive(new int[]{3,4,-1,1}));
//        System.out.println(new Problems41().firstMissingPositive(new int[]{7,8,9,11,12}));
//        System.out.println(new Problems41().firstMissingPositive(new int[]{1000, -1}));
//        System.out.println(new Problems41().firstMissingPositive(new int[]{0,2,2,1,1}));
//        System.out.println(new Problems41().firstMissingPositive2(new int[]{-10,-3,-100,-1000,-239,1}));
//        System.out.println(new Problems41().firstMissingPositive2(new int[]{2,10,12,20,4,19,16,-10,17,-6,-6,4,12,-5,3,18,-5,-6,3,6,4,13}));
//        System.out.println(new Problems41().firstMissingPositive(new int[]{10,7,12,-2,-10,9,3,-6,-5,-3,-4,-8,3,9}));
//        System.out.println(new Problems41().firstMissingPositive(new int[]{2,3,-6,-5,-9,8,-9,-9,-3,-3}));
//        System.out.println(new Problems41().firstMissingPositive(new int[]{39,8,43,12,38,11,-9,12,34,20,44,32,10,22,38,9,45,26,-4,2,1,3,3,20,38,17,20,25,41,35,37,18,37,34,24,29,39,9,36,28,23,18,-2,28,34,30}));
    }
}
