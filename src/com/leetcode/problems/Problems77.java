package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problems77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        if(n <= 0 || k <= 0 || k > n) return lists;
        List<Integer> list = new ArrayList<>();
        backtrace(lists, list, 1, n, k);
        return lists;
    }

    private void backtrace(List<List<Integer>> lists, List<Integer> list, int start, int n, int k) {
        if(list.size() == k)
            lists.add(new ArrayList<Integer>(list));
        else {
//            while(start <= n) {
            for(int i = start; i <= n; i++) {
                list.add(i);
                backtrace(lists, list, i + 1, n, k);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Problems77().combine(4, 3);
        System.out.println(lists);
    }
}
