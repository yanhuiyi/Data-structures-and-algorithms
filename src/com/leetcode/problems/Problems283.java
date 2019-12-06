package com.leetcode.problems;

public class Problems283 {
    public void moveZeroes(int[] nums) {
        int totalCount = nums.length;

        int i = 0, j = 0;

        for(; i < totalCount; i++) {
            if(nums[i] != 0)
                nums[j++] = nums[i];
        }


        while(j < totalCount) {
            nums[j++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};

        new Problems283().moveZeroes(nums);
        for(int num : nums)
            System.out.println(num);
    }

}
