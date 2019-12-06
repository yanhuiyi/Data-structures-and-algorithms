package com.datastructures.dp;

public class Problems1 {

    public static void main(String[] args) {
        int[] prev = {0, 0, 0, 0, 1, 0, 2, 3, 5};
        int[] profit = {0, 5, 1, 8, 4, 6, 3, 2, 4};

        int[] opt = new int[9];
        opt[0] = 0;
        for (int i = 1; i < 9; i++) {
            opt[i] = Math.max(opt[i - 1], profit[i] + opt[prev[i]]);
        }

        for(int i : opt) {
            System.out.println(i);
        }
    }
}
