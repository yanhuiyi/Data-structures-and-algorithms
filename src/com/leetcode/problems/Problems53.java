package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problems53 {

    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];

        List<Integer> list = new ArrayList<>();

        for(int i : nums) {
            list.add(i);
        }

        if((int)Collections.max(list, null) < 0) return (int)Collections.max(list, null);

        int localMax = 0, globalMax = 0;

        for(int i = 0; i < nums.length; i++) {
            localMax = Math.max(0, localMax + nums[i]);
            globalMax = Math.max(globalMax, localMax);
        }

        return globalMax;
    }

    public int maxSubArrayDivideAndConquer(int[] nums) {
        return maxSum(nums, 0, nums.length - 1);
    }

    // Time Complexity: O(nlogn)
    public int maxSum(int[] nums, int start, int end) {
        if(start == end)
            return nums[start];

        if(start > end)
            return Integer.MIN_VALUE;

        int mid = (end - start) / 2 + start;

        int leftMax = maxSum(nums, start, mid - 1);
        int rightMax = maxSum(nums, mid + 1, end);

        int midLeftSum = 0, midRightSum = 0;

        for(int i = mid - 1, sum = 0; i >= start; --i) {
            sum += nums[i];
            if(midLeftSum < sum) {
                midLeftSum = sum;
            }
        }

        for(int i = mid + 1, sum = 0; i <= end; ++i) {
            sum += nums[i];
            if(midRightSum < sum) {
                midRightSum = sum;
            }
        }

        return Math.max(Math.max(leftMax, rightMax), (midLeftSum + midRightSum + nums[mid]));
    }

    // Time Complexity: O(n)
    public int maxSubArrayLinear(int[] nums) {
        int thisSum = nums[0], maxSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(thisSum < 0)
                thisSum = nums[i];
            else
                thisSum += nums[i];

            if(thisSum > maxSum)
                maxSum = thisSum;
        }
        return maxSum;
    }

    public int maxSubArrayDP(int[] nums) {
        int n = nums.length;
        // Each element in dp array is the largest sum in current position i
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < n; i++) {
            /*
                if dp[i-1] > 0, then dp[i] = dp[i -1] + nums[i]
                if dp[i-1] < 0, then dp[i] = nums[i]
                dp[i] selects the larger value of them
             */
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if(dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(new Problems53().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(new Problems53().maxSubArrayDivideAndConquer(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(new Problems53().maxSubArrayLinear(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(new Problems53().maxSubArrayLinear(new int[]{ -2, 1}));
        System.out.println(new Problems53().maxSubArrayDP(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(new Problems53().maxSubArrayDP(new int[]{ -2, 1}));
    }
}
