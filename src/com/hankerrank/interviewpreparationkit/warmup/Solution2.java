package com.hankerrank.interviewpreparationkit.warmup;

import java.util.Stack;

public class Solution2 {
    static int countingValleys(int n, String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        int result = 0;

        for(char c : s.toCharArray()) {
            if(c == 'U') {
                count = count + 1;
            } else {
                count = count - 1;
                if(count == -1) {
                    result = result + 1;
                }
            }

        }
        return result ;
    }

    public static void main(String[] args) {
        System.out.println(countingValleys(8, "UDDDUDUU"));
    }
}
