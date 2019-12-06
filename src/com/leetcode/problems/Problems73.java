package com.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class Problems73 {

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for(int row = 0; row < rows; ++row) {
            for(int col = 0; col < cols; ++col) {
                if(!rowSet.contains(row) && !colSet.contains(col) && matrix[row][col] == 0) {
                    rowSet.add(row);
                    colSet.add(col);
                    for(int i = 0; i < rows; ++i) matrix[i][col] = 0;
                    for(int i = 0; i < cols; ++i) matrix[row][i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        new Problems73().setZeroes(matrix);
        System.out.println(matrix);
    }
}
