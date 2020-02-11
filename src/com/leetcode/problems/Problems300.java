package com.leetcode.problems;

public class Problems300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;

        int[] dp = new int[n];

        for(int i = 0; i < n; i++)
            dp[i] = 1;

        int top = nums[0];
        int max = 1;

        // Initial commit without checking answers
        for(int i = 1; i < n; i++) {
            if(nums[i] > nums[i - 1]) {
                top = nums[i];
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
            if(max < dp[i])
                max = dp[i];
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 3, 1, 4};
        System.out.println(new Problems300().lengthOfLIS(nums));
        nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(new Problems300().lengthOfLIS(nums));
        nums = new int[]{4,10,4,3,8,9};
        System.out.println(new Problems300().lengthOfLIS(nums));
    }
}
