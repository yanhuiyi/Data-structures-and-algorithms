package com.leetcode.problems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problems90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;

        List<Integer> subset = new ArrayList<>();

        Arrays.sort(nums);
        backtrace(nums, subset, ans, 0);

        return ans;
    }

    private void backtrace(int[] nums, List<Integer> item, List<List<Integer>> result, int i) {
        if(i >= nums.length)
            return;

        item.add(nums[i]);
        result.add(new ArrayList<Integer>(item));
        backtrace(nums, item, result, i + 1);
        item.remove(item.size() - 1);
        // if the value of following num is equal to its previous one, skip it.
        while(i + 1 < nums.length && nums[i] == nums[i + 1]) ++i;
        backtrace(nums, item, result, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Problems90().subsetsWithDup(new int[]{5, 5, 5, 5, 5}));
        System.out.println(new Problems90().subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
    }
}
