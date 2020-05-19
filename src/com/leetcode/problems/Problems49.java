package com.leetcode.problems;

import java.util.*;

/**
 *  Sort string in strs and make it as a key and put raw string as value
 *  Filter out all values in map
 */
public class Problems49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Declare Map<String, List> cannot convert with new ArrayList<> at line #25 will generate error
        // Error:(25, 29) java: incompatible types: cannot infer type arguments for java.util.ArrayList<>
        //    reason: cannot infer type-variable(s) E
        //      (argument mismatch; java.util.Collection<java.util.List> cannot be converted to java.util.Collection<? extends java.util.List<java.lang.String>>)
        //
        // Declare Map<String, List<String>> resolves the issue
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char chs[] = str.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            List<String> value = map.get(key);
            if(value == null)
                value = new ArrayList<String>();
            value.add(str);
            map.put(key, value);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Problems49().groupAnagrams(strs));
    }
}
