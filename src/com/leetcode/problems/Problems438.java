package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problems438 {
    public List<Integer> findAnagrams2(String s, String p){

        List<Integer> res = new ArrayList<>();
       if(s.length() == 0) return res;

       Map<Character, Integer> amp = new HashMap<>();

       int[] map = new int[26];

       for(char c : p.toCharArray())
           map[c - 'a']++;

       int i = 0;
       while (i < s.length()) {
          boolean success = true;

          int[]  tmp =  map;
          for(int j = i; j < i + p.length(); j++){
              if(--tmp[s.charAt(j) - 'a'] < 0) {
                  success = false;
                  break;
              }
          }

          if(success) {
              res.add(i);
          }
          ++i;
       }
       return res;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if (s.length() < p.length())
            return res;

        char[] schars = s.toCharArray();
        char[] pchars = p.toCharArray();

        int[] hash = new int[26];

        for(int i = 0; i < pchars.length; ++i)
            hash[pchars[i] - 'a']++;

        int l = 0, count = 0;
        int length = p.length();

        for(int r = 0; r < schars.length; ++r) {
            hash[schars[r] - 'a']--;

            if(hash[schars[r] - 'a'] >= 0)
                count++;

            if(r > length - 1) {
                hash[schars[l] - 'a']++;

                if(hash[schars[l] - 'a'] > 0)
                    count--;

                l++;
            }

            if(count == length)
                res.add(l);
        }

        return res;
    }



    public static void main(String[] args) {
        System.out.println(new Problems438().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new Problems438().findAnagrams2("cbaebabacd", "abc"));
    }
}
