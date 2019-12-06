package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Problems152 {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        return maxProductDivideAndConquer(nums, 0, nums.length - 1);

    }

    private int maxProductDivideAndConquer(int[] nums, int left, int right) {
        if(left == right) return nums[left];

        if(left > right) return Integer.MIN_VALUE;

        int mid = (right - left) / 2 + left;

        int maxproductLeft = maxProductDivideAndConquer(nums, left, mid - 1);

        int maxproductRight = maxProductDivideAndConquer(nums, mid + 1, right);

        int maxproductBeforeMid = 1, maxproductAfterMid = 1;

        for(int i = mid - 1, product = 1; i >= left; i--) {
            product *= nums[i];
            if(product > maxproductBeforeMid) {
                maxproductBeforeMid = product;
            }
        }

        for(int i = mid + 1, product = 1; i <= right; i++) {
            product *= nums[i];
            if(product > maxproductAfterMid) {
                maxproductAfterMid = product;
            }
        }

        return Math.max(Math.max(maxproductLeft, maxproductRight), maxproductBeforeMid * nums[mid] * maxproductAfterMid);
    }

    public int maxProduct2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int max = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int nextMax = curMax * nums[i];
            int nextMin = curMin * nums[i];

            curMax = Math.max(nums[i], Math.max(nextMax, nextMin));
            curMin = Math.min(nums[i], Math.min(nextMax, nextMin));

            max = Math.max(curMax, max);
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {

        }

        return max;

    }

    public static void main(String[] args) {
       // System.out.println(new Problems152().maxProduct(new int[] {-3, -4}));
        //System.out.println(new Problems152().maxProduct(new int[] {3, -4}));
        System.out.println(new Problems152().maxProduct2(new int[] {2, -1, 3}));
    }

}
