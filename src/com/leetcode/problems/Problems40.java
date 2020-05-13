package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 像这种结果要求返回所有符合要求解的题十有八九都是要利用到递归，而且解题的思路都大同小异，
 * 相类似的题目有 Path Sum II，Subsets II，Permutations，Permutations II，Combinations 等等，
 * 如果仔细研究这些题目发现都是一个套路，都是需要另写一个递归函数
 */
public class Problems40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        List<Integer> item = new ArrayList<>();
        backtrace(candidates, target, result, item, 0);
        return result;
    }

    private void backtrace(int[] candidates, int target, List<List<Integer>> result, List<Integer> item, int index) {
       if(target < 0)
           return;
       if(target == 0) {
           result.add(new ArrayList<>(item));
           return;
       }

       for(int i = index; i < candidates.length; i++) {
           // The following line does the same thing as line 27
           // if(i > index && candidates[i] == candidates[i - 1]) continue;
           item.add(candidates[i]);
           while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) ++i;
           backtrace(candidates, target - candidates[i], result, item, i + 1);
           item.remove(item.size() - 1);
       }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Problems40().combinationSum2(new int[] {10,1,2,7,6,1,5}, 8);
        System.out.println(lists);
    }
}
