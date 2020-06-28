package com.leetcode.problems;

import java.util.LinkedList;

public class Problems200 {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        //                  x-1,y
        //          x,y-1   x,y     x,y+1
        //                  x+1,y
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    LinkedList<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i, j});
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for(int[] dir : dirs) {
                            int x = cur[0] + dir[0];
                            int y = cur[1] + dir[1];
                            if(x >= 0 && x < rows && y >=0 && y < cols && grid[x][y] == '1') {
                                grid[x][y] = '0';
                                queue.add(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(new Problems200().numIslands(grid));
        char[][] grid2 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(new Problems200().numIslands(grid2));
    }
}
