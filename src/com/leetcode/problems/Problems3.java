package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Problems3 {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.printf("ans: %s", new Problems3().lengthOfLongestSubstring("dvdf"));
        System.out.println();
//
//        int ans2 = lengthOfLongestSubstring2("ceoyvtfeiu");
//        System.out.printf("ans: %s", ans2);

        String s = "dvdf";
        int[] index = new int[128];

        for(int j = 0; j < s.length(); j++) {
            index[s.charAt(j)] = j + 1;
            System.out.printf("%s => %s \n", s.charAt(j), index[s.charAt(j)]);
        }
    }

}
