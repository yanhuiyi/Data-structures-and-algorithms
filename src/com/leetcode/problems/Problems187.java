package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Go through all substring from index 0 to -10. Construct a map, put substring as key and increase the value by 1
 * Filter out all values which is larger than 1 in map
 */
public class Problems187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(int i = 0; i < s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if(map.containsKey(sub))
                map.put(sub, map.get(sub) + 1);
            else
                map.put(sub, 1);
        }

        for(Map.Entry<String, Integer> entry : map.entrySet())
            if(entry.getValue() > 1)
                result.add(entry.getKey());

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problems187().findRepeatedDnaSequences("AAAAAAAAAA"));
    }
}
