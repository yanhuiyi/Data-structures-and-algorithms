package com.leetcode.problems;

public class Problems42 {

    public int trap(int[] height) {

        int[] left = new int[height.length];
        int[] right = new int[height.length];

        left[0] = 0;

        for (int i = 1, max = 0; i < height.length; i++) {
            max = Math.max(max, height[i - 1]);
            left[i] = max;
        }

        right[height.length - 1] = 0;

        for (int i = height.length - 2, max = 0; i >= 0; i--) {
            max = Math.max(max, height[i + 1]);
            right[i] = max;
        }

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int temp = Math.min(left[i], right[i]);
            sum += (height[i] < temp) ?  temp - height[i] : 0;
        }


        return sum;
    }


    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(new Problems42().trap(height));
    }


}
