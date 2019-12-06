package com.leetcode.problems;

public class Problems48 {

    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Doesn't work when 4 x 4 matrix
//        for(int i = 0; i < rows  - 1; i++) {
//            for(int j = 0; j < cols - 1; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[rows - j - 1][cols - i - 1];
//                matrix[rows - j - 1][cols - i - 1] = temp;
//            }
//        }
//
//        for (int i = 0; i < rows / 2; i++) {
//            for (int j = 0; j < cols; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[rows - 1 - i][j];
//                matrix[rows - 1 - i][j] = temp;
//            }
//        }

        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][rows - 1 - j];
                matrix[i][rows - 1 - j] = temp;
            }
        }

//        int temp = 0;
//        int height = matrix.length;
//
//        for (int i = 0; i < height / 2; i++) {
//            for (int j = i; j < height - 1 - i; j++) {
//                temp = matrix[i][j];
//                matrix[i][j] = matrix[height - j - 1][i];
//                matrix[height - j - 1][i] = matrix[height - i - 1][height - j - 1];
//                matrix[height - i - 1][height - j - 1] = matrix[j][height - i - 1];
//                matrix[j][height - i - 1] = temp;
//            }
//        }

        System.out.println(matrix);
    }

    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%s ", matrix[i][j]);
            }
            System.out.println();
        }

        new Problems48().rotate(matrix);

        System.out.println("After: ");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%s ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
