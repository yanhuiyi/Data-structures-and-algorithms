package com.leetcode.problems;

import java.util.Stack;

public class Problems300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = 1;
        int max = 1;

        for(int i = 1; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            if(max < dp[i])
                max = dp[i];
        }

        return max;
    }

    public int lengthOfLIS2(int[] nums) {
        if(nums.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(nums[0]);

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > stack.lastElement()) {
                stack.add(nums[i]);
            } else if(nums[i] < stack.firstElement()) {
                stack.set(0, nums[i]);
            } else {
                int left = 0, right = stack.size();
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if(stack.get(mid) < nums[i]) left = mid + 1;
                    else right = mid;
                }
                stack.set(right, nums[i]);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 3, 1, 4};
        System.out.println(new Problems300().lengthOfLIS(nums));
        System.out.println(new Problems300().lengthOfLIS2(nums));
        nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(new Problems300().lengthOfLIS(nums));
        System.out.println(new Problems300().lengthOfLIS2(nums));
        nums = new int[]{4,10,4,3,8,9};
        System.out.println(new Problems300().lengthOfLIS(nums));
        System.out.println(new Problems300().lengthOfLIS2(nums));
    }
}
