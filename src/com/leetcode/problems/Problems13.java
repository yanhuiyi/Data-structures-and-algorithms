package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Problems13 {

    public int romanToInt(String s) {
        int m = s.length();

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
//
//        for(int i = 0; i < m; i++) {
//
//            if(s.charAt(i) == 'I' && (i + 1 < m) && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
//                res += (map.get(s.charAt(i + 1)) - map.get(s.charAt(i)));
//                i = i + 1;
//            } else if(s.charAt(i) == 'X' && (i + 1 < m)  && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
//                res += (map.get(s.charAt(i + 1)) - map.get(s.charAt(i)));
//                i = i + 1;
//            } else  if(s.charAt(i) == 'C' && (i + 1 < m)  && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
//                res += (map.get(s.charAt(i + 1)) - map.get(s.charAt(i)));
//                i = i + 1;
//            } else {
//                res += (map.get(s.charAt(i)));
//            }
//        }

        for(int i = 0; i < m; i++) {
            int val = map.get(s.charAt(i));
            if(i == m - 1 || map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) res += val;
            else res -= val;
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(new Problems13().romanToInt("MCMXCIV"));
    }
}
