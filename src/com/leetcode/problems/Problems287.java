package com.leetcode.problems;

public class Problems287 {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int index = indexOf(nums[i], nums, 0);
            int nextIndex = indexOf(nums[i], nums, index + 1);

            if(nextIndex != -1)
                return nums[nextIndex];

        }
        return -1;

    }

    private int indexOf(int num, int[] nums, int offset) {
        for(int i = offset; i < nums.length; i++)
            if(nums[i] == num)
                return i;

        return -1;
    }

    public int findDuplicate2(int[] nums) {
            // Find the intersection point of the two runners.
            int tortoise = nums[0];
            int hare = nums[0];
            do {
                tortoise = nums[tortoise];
                hare = nums[nums[hare]];
            } while (tortoise != hare);

            // Find the "entrance" to the cycle.
            int ptr1 = nums[0];
            int ptr2 = tortoise;
            while (ptr1 != ptr2) {
                ptr1 = nums[ptr1];
                ptr2 = nums[ptr2];
            }

            return ptr1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};

        System.out.println(new Problems287().findDuplicate(nums));
        System.out.println(new Problems287().findDuplicate2(nums));
    }
}
