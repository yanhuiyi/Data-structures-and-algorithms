package com.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Problems58 {

    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[0][0];

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        Stack<int[]> stack = new Stack();
        stack.push(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            int[] cur = stack.peek();

            if(cur[1] < intervals[i][0]) {
                stack.push(intervals[i]);
            } else {
                int[] temp = stack.pop();
                stack.push(new int[]{temp[0], Math.max(temp[1], intervals[i][1])});
            }
        }

        int[][] ans = new int[stack.size()][2];

        int i = 0;
        for(int[] item : stack) {
            ans[i++] = item;
        }

        return ans;
    }

    public static void main(String[] args) {
       int[][] array = {{1, 4}, {0, 4}};

       Arrays.sort(array, new Comparator<int[]>() {
         public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
         };
       });

       System.out.println(array);

    }
}
