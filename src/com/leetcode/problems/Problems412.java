package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problems412 {

    public static List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            if( i % 3 == 0) {
                ans.add("Fizz");
            } else if( i % 5 == 0) {
                ans.add("Buzz");
            } else if( i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            } else {
                ans.add(String.valueOf(i));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(1));
    }
}
