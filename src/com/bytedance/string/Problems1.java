package com.bytedance.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problems1 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
       StringBuilder sb = new StringBuilder(String.valueOf(s.charAt(0)));
       int maxLength = 1;
       int len = 1;

       while(right < s.length()) {
           if(!set.contains(s.charAt(right))) {
               set.add(s.charAt(right++));
               maxLength = Math.max(maxLength, set.size());
           } else {
               set.remove(s.charAt(left++));
           }
       }

       return maxLength;

       //for(int i = 1; i < s.length(); i++) {
       //  if(sb.indexOf(String.valueOf(s.charAt(i))) == -1) {
       //     len++;
       //     sb.append(s.charAt(i));
       //  } else {
       //      len = 1;
       //      sb = new StringBuilder(String.valueOf(s.charAt(i)));
       //  }
       //  maxLength = Math.max(maxLength, len);
       //}
       //return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();

        int length = 0;

        for(int i = 0, j = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
               j = Math.max(map.get(s.charAt(i)), j);

            }
            length = Math.max(length, i - j + 1);
            map.put(s.charAt(i), i + 1);
        }
        return length;
    }

    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] sArr = s.toCharArray();
        int[] hash = new int[256];

        int l = 0, result = 1;
        for (int r = 0; r < sArr.length; ++r) {
            hash[sArr[r]]++;

            while (hash[sArr[r]] != 1) {
                hash[sArr[l]]--;
                l++;
            }

            result = Math.max(result, r - l + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problems1().lengthOfLongestSubstring3("dddvf"));
        System.out.println(new Problems1().lengthOfLongestSubstring("dvdf"));
        System.out.println(new Problems1().lengthOfLongestSubstring("vddf"));
        System.out.println(new Problems1().lengthOfLongestSubstring2("dvdv"));
        System.out.println(new Problems1().lengthOfLongestSubstring2("abcabcbb"));
    }
}
