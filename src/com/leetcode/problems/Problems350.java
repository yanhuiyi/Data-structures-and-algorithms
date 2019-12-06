package com.leetcode.problems;

import java.util.*;

public class Problems350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for(int num: nums2) {
            if(map.containsKey(num) && map.get(num) > 0) {
                ans.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        Iterator<Integer> it = ans.iterator();

        int[] ret = new int[ans.size()];

        int i = 0;
        while(it.hasNext())
            ret[i++] = it.next();


        return ret;
    }


    public static void main(String[] args) {

        int[] nums1 = {4, 9, 5 };
        int[] nums2 = {9, 4, 9, 8, 4};

        System.out.println(new Problems350().intersect(nums1, nums2));

    }
}
