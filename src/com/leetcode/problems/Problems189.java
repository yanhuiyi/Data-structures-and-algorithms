package com.leetcode.problems;

public class Problems189 {

    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            temp[( i + k) % nums.length] = nums[i];
        }

        for(int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }


    public static void main(String[] args) {
        new Problems189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}
