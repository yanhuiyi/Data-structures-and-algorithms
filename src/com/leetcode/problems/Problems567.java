package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Problems567 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;

        char[] s1chars = s1.toCharArray();
        char[] s2chars = s2.toCharArray();

        int[] hash = new int[26];

        for(char c : s1.toCharArray())
            hash[c - 'a']++;

        int l = 0, count = 0;

        // s1="ab"
        // s2="eidbaooo"
        for(int r = 0; r < s2chars.length; ++r) {
            hash[s2chars[r] - 'a']--;

            if(hash[s2chars[r] - 'a'] >= 0)
                count++;

            if(r >= s1.length()) {
                hash[s2chars[l] - 'a']++;

                if(hash[s2chars[l] - 'a'] >= 1)
                    count--;
                l++;
            }

            if(count == s1.length())
                return true;
        }
       return false;
    }

    // s1="ab"
    // s2="eidbaooo"
    public boolean checkInclusion2(String s1, String s2) {
        //if(s1.length() > s2.length()) return false;
        int left = 0, right = 0;

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();

        for(char c : s1.toCharArray())
            needs.put(c, needs.getOrDefault(c, 0) + 1);

        int match = 0;

        while (right < s2.length()) {
            char c1 = s2.charAt(right);
            if(needs.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if(Integer.compare(window.get(c1), needs.get(c1)) == 0)
                    match++;
            }
            right++;

            while (match == needs.size()) {
                if (right - left == s1.length())
                    return true;
                char c2 = s2.charAt(left);
                if (needs.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);
                    if (Integer.compare(window.get(c2), needs.get(c2)) < 0)
                        match--;
                }
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new Problems567().checkInclusion("ab", "eidbaooo"));
//        System.out.println(new Problems567().checkInclusion2("ab", "eidbaooo"));
//        System.out.println(new Problems567().checkInclusion("ab", "eidboaoo"));
        System.out.println(new Problems567().checkInclusion2("ab", "eidboabo"));
    }
}
