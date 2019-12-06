package com.leetcode.problems;

public class Problems215 {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;

        while (true) {
            int pos = quickSelect(nums, left, right);
            if (pos == k - 1) return nums[pos];
            if (pos > k - 1)
                right = pos - 1;
            else
                left = pos + 1;
        }
    }

    private int quickSelect(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1, r = right;

        while (l < r) {
            if(nums[l] < pivot && nums[r] > pivot) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
               //l++;
               //r--;
                ++l;
                --r;
            }

            if(nums[l] >= pivot) ++l;
            if(nums[r] <= pivot) --r;
        }
        nums[left] = nums[r];
        nums[r]= pivot;

        return r;
    }

    public static void main(String[] args) {
        int[] array = {3,2,3,1,2,4,5,5,6};
        System.out.println(new Problems215().findKthLargest(array,4));
    }
}
