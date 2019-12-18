package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Problems76 {
    public String minWindow(String s, String t) {
        int start = 0, minlen = Integer.MAX_VALUE;
        int left = 0, right = 0;

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();

        for(Character c : t.toCharArray())
            needs.put(c, needs.getOrDefault(c, 0) + 1);

        int match = 0;

        while (right < s.length()) {
            char c1 = s.charAt(right);
            if(needs.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if(window.get(c1).equals(needs.get(c1)))
                    match++;
            }

            right++;

            while (match == needs.size()) {
                if(right - left < minlen) {
                    start = left;
                    minlen = right -  left;
                }

                char c2 = s.charAt(left);
                if(needs.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);
                    if(window.get(c2) < needs.get(c2))
                        match--;
                }
                left++;
            }
        }

        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start + minlen);
    }

    public static void main(String[] args) {
        System.out.println(new Problems76().minWindow("ADOBECODEBANC", "ABC"));
    }
}
