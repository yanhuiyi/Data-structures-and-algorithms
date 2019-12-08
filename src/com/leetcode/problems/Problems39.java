package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problems39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if(candidates == null || candidates.length == 0 || target < 0) return lists;
        List<Integer> list = new ArrayList<>();
        process(0, candidates, lists, target, list);
        return lists;
    }

    private void process(int start, int[] candidates, List<List<Integer>> lists, int target, List<Integer> list) {
        if(target < 0)
            return;
        if(target == 0)
           lists.add(new ArrayList<>(list));
        else {
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                process(i, candidates, lists,target - candidates[i], list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Problems39().combinationSum(new int[] {2, 3, 6, 7}, 7);
        System.out.println(lists);
    }
}
