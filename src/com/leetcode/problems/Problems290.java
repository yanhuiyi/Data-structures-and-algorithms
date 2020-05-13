package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Problems290 {
    public boolean wordPattern(String pattern, String str) {
        String[] strArray = str.split(" ");

        int patternLen = pattern.length();
        int strLen = strArray.length;

        if(patternLen != strLen)
            return false;

        Map<String, String> patternStrMap = new HashMap<String, String>();

        int i = 0;
        for(; i < strLen; i++) {
            if(patternStrMap.containsKey(String.valueOf(pattern.charAt(i)))) {
                if(!patternStrMap.get(String.valueOf(pattern.charAt(i))).equals(strArray[i])) {
                    return false;
                }
            } else {
                if(patternStrMap.containsValue(strArray[i])) {
                    return false;
                }
                patternStrMap.put(String.valueOf(pattern.charAt(i)), strArray[i]);
            }
        }

        return i == strLen;
    }

    public static void main(String[] args) {
        System.out.println(new Problems290().wordPattern("", "beef"));
        System.out.println(new Problems290().wordPattern("abba", "dog cat cat dog"));
        System.out.println(new Problems290().wordPattern("abba", "dog cat cat fish"));
    }
}
