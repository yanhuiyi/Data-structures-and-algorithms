package com.leetcode.problems;

public class Problems34 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        if(nums == null || nums.length == 0) return ans;

        int low = 0, high = nums.length - 1;

        if(nums[low] > target || nums[high] < target) return ans;

        while(low < high) {
            int mid = (high - low) / 2 + low;

            if(nums[mid] < target) {
                low = mid + 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid;
                high = mid;
                while(low - 1>= 0 && nums[low - 1] == target) low--;
                while(high + 1 < nums.length && nums[high + 1] == target) high++;
                break;
            }
        }

        if(nums[low] == target) {
            ans[0] = low;
            ans[1] = high;
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] ans = new Problems34().searchRange(new int[]{5,7,7,8,8,10}, 8);
//        int[] ans = new Problems34().searchRange(new int[]{1}, 1);
        int[] ans = new Problems34().searchRange(new int[]{1, 4}, 4);
        for(int i : ans) {
            System.out.println(i);
        }
    }
}
