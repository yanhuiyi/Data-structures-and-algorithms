package com.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problems128 {

    public int longestConsecutive(int[] nums) {


        int res = 0;
        int longest = 0;
        if(nums == null || nums.length == 0) return longest;

        int cur = nums[0];

        for(int i = 0; i < nums.length; i++) {
            cur = nums[i];
            res = 1;
            boolean found = true;
            while(found) {
                int j = 0;
                for (; j < nums.length; j++) {
                    if (cur + 1 == nums[j]) {
                        found = true;
                        cur = cur + 1;
                        break;
                    }
                }

                if (j < nums.length) {
                    res = res + 1;
                } else {
                    found = false;
                }
            }
            longest = Math.max(longest, res);
        }

        return longest;
    }

    public int longestConsecutive2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int longest = 0;
        if(nums == null || nums.length == 0) return longest;

        for(int num : nums) {
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int leng = left + right + 1;

            longest = Math.max(longest, leng);

            map.put(num, leng);
            map.put(num - left, leng);
            map.put(num + right, leng);
        }

        return longest;
    }

    public int longestConsecutive3(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        for(int num : nums) {
            if(set.remove(num)) {
                int prev = num - 1, next = num + 1;
                while(set.remove(prev)) --prev;
                while(set.remove(next)) ++next;
                res = Math.max(res, next - prev - 1);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new Problems128().longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
        System.out.println(new Problems128().longestConsecutive(new int[] { 100, 101, 5, 6, 4}));

        System.out.println(new Problems128().longestConsecutive2(new int[] {100, 4, 200, 1, 3, 2}));
        System.out.println(new Problems128().longestConsecutive2(new int[] { 100, 101, 5, 6, 4}));

        //System.out.println(new Problems128().longestConsecutive3(new int[] {100, 4, 200, 1, 3, 2}));
        System.out.println(new Problems128().longestConsecutive3(new int[] { 100, 101, 5, 6, 4}));
    }
}
