package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problems15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;

        Arrays.sort(nums);

        // [-4, -1, -1, -1, 0, 1, 2]

        for(int i = 0; i < len; i++) {
            int a = nums[i];

            // To skip repetitive numbers
            if(i >= 1 && nums[i - 1] == a)
                continue;

            int left = i + 1;
            int right = len - 1;

            while(left < right) {
                int b = nums[left];
                int c = nums[right];

                int sum = a + b + c;

                if(sum < 0) {
                    left += 1;
                } else if (sum > 0) {
                    right -= 1;
                } else {
                    ans.add(Arrays.stream(new  int[]{a, b, c}).boxed().collect(Collectors.toList()));
                    while(left < right && nums[left] == nums[left + 1])
                        left += 1;

                    while(left < right && nums[right] == nums[right - 1])
                        right -= 1;

                    left += 1;
                    right -= 1;
                }
            }

        }
        return ans;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            int a = nums[i];

            if(i >= 1 && nums[i - 1] == a) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int b = nums[left];
                int c = nums[right];

                int sum = a + b + c;

                if(sum > 0) {
                    --right;
                } else if(sum < 0) {
                    ++left;
                } else {
                    ans.add(new ArrayList<Integer>(Arrays.asList(a, b, c)));
                    while (left < right && nums[left] == nums[left + 1]) ++left;
                    while (left < right && nums[right] == nums[right - 1]) --right;
                    ++left;
                    --right;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1, -1, 0, 1, 2, -1, -4};
        System.out.println(new Problems15().threeSum(nums));
        System.out.println(new Problems15().threeSum2(nums));
    }
}
