package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problems78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length == 0) return ans;

        List<Integer> subset = new ArrayList<>();

        dfs(nums, subset, ans, 0);

        return ans;
    }

    private void dfs(int[] nums, List<Integer> cur, List<List<Integer>> ans, int index) {
        ans.add(new ArrayList<Integer>(cur));

        for (int i = index; i < nums.length; ++i) {
            cur.add(nums[i]);
            dfs(nums, cur, ans, i + 1);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problems78().subsets(new int[]{1, 2, 3}));
    }
}
