package com.leetcode.problems;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxArea = 0;

        for(int i = 0; i < height.length - 1; i++) {
            for(int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                if(area > maxArea) {
                    maxArea = area;
                }
            }
        }

        int i = 0;
        int j = height.length - 1;
        int maxArea2 = 0;

        while(i < height.length / 2) {
            int area = Math.min(height[i], height[j]) * (j - i);
            if(area > maxArea2) {
                maxArea2 = area;
            }
            i++;
        }

        // [2,3,4,5,18,17,6]
        return maxArea2;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
