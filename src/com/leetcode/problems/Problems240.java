package com.leetcode.problems;

public class Problems240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;

        while (i >= 0 && j < matrix[0].length) {
            if(matrix[i][j] == target) return true;

            if(target > matrix[i][j])
                j++;
            else
                i--;
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {
            if(matrix[i][j] == target) return true;

            if(target > matrix[i][j])
                i++;
            else
                j--;
        }

        return false;
    }

    public static void main(String[] args) {
       int[][] matrix = {
          {1,   4,  7, 11, 15},
          {2,   5,  8, 12, 19},
          {3,   6,  9, 16, 22},
          {10, 13, 14, 17, 24},
          {18, 21, 23, 26, 30}
        };
        System.out.println(new Problems240().searchMatrix(matrix, 5));
        System.out.println(new Problems240().searchMatrix2(matrix, 5));
    }
}
