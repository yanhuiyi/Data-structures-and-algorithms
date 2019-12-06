package com.leetcode.problems;

public class Problems84 {

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];
            for(int j = i; j >= 0; j--) {
                minHeight = Math.min(minHeight, heights[j]);
                int area = minHeight * ( j - i + 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public int largestRectangleArea2(int[] heights) {
        int res = 0;

        for(int i = 0; i < heights.length; i++) {
            if (i + 1 < heights.length && heights[i] <= heights[i + 1])
                continue;
            int minHeight = heights[i];

            for(int j = i; j >= 0; j--) {
                minHeight = Math.min(minHeight, heights[j]);
                int area = minHeight * (i - j + 1);
                res = Math.max(res, area);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 5, 6, 2, 3};
        int[] nums2 = new int[]{2, 4};

        System.out.println(new Problems84().largestRectangleArea2(nums));
        System.out.println(new Problems84().largestRectangleArea2(nums2));
    }
}
