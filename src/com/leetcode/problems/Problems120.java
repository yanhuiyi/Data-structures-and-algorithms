package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problems120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if(size == 0) return 0;

        int[][] dp = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++)
                dp[i][j] = 0;
        }

        for(int i = 0; i < size; i++)
            dp[size - 1][i] = triangle.get(size - 1).get(i);

        for(int i = size - 2; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(3, 4)));
        triangle.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        triangle.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));
        System.out.println(new Problems120().minimumTotal(triangle));
    }
}
