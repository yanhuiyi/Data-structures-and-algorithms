package com.leetcode.problems;

public class Problems26 {

    public int removeDuplicates(int[] nums) {
        // [1, 1, 1, 2, 4, 4, 5]
        // [1, 2, 1, 2, 4, 4, 5]
        // [1, 2, 4, 2, 4, 4, 5]
        if(nums == null || nums.length == 0) return 0;

        int count = 1;

        for (int i = 1; i < nums.length ; i++) {
            if(nums[i - 1] != nums[i]) {
                nums[count++] = nums[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Problems26().removeDuplicates(new int[]{1, 1, 1, 2, 4, 4, 5}));
    }
}
