package com.leetcode.problems;

import javax.swing.*;
import java.util.*;

public class Problems315 {

//    public static List<Integer> countSmaller(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for(int i = 0; i < nums.length; i++) {
//            int count = 0;
//            map.put(i, count);
//            for(int j = i + 1; j < nums.length; j++) {
//                if(nums[j] < nums[i]) {
//                    map.put(i, ++count);
//                }
//            }
//        }
//
//        List<Integer> ans = new ArrayList<>();
//
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            ans.add(entry.getValue());
//        }
//
//        return ans;
//    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] ans = new Integer[n];
        List<Integer> sorted = new ArrayList<>();

        for(int i = n - 1; i >= 0; i--) {
            int index = findIndex(sorted, nums[i]);
            ans[i] = index;
            sorted.add(index, nums[i]);
        }
        return Arrays.asList(ans);
    }

    private int findIndex(List<Integer> sorted, int target) {
        int i = 0;
        int j = sorted.size();

        while (i < j) {
            int mid = i + (j - i) / 2;
            if(sorted.get(mid) < target)
                i = mid + 1;
            else
                j = mid;
        }

        return i;
    }


    public static void main(String[] args) {
        System.out.println(new Problems315().countSmaller(new int[]{5, 2, 6, 1}));
    }
}
