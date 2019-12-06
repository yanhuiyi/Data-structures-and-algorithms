package com.datastructures.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class Problems2 {

    private boolean rec_subset(int[] arr, int i, int sum) {
        if(sum == 0)
            return true;
        else if(i == 0)
            return arr[0] == sum;
        else if(arr[i] > sum)
            return rec_subset(arr, i - 1, sum);
        else {
            boolean choosed = rec_subset(arr, i - 1, sum - arr[i]);
            boolean unchoosed = rec_subset(arr, i - 1, sum);
            return choosed || unchoosed;
        }
    }

    private boolean dp_subset(int[] arr, int S) {
        boolean[][] subset = new boolean[arr.length][S + 1];

        for (int i = 0; i < subset.length; i++) {
            subset[i][0] = true;
        }

        for(int i = 0; i < subset[0].length; i++) {
            subset[0][i] = false;
        }

        subset[0][arr[0]] = true;

        for(int i = 1; i < subset.length; i++) {
            for(int s = 1; s < S + 1; s++) {
                if(arr[i] > s)
                    subset[i][s] = subset[i - 1][s];
                else {
                    boolean chose = subset[i - 1][s - arr[i]];
                    boolean unchose = subset[i - 1][s];
                    subset[i][s] = chose || unchose;
                }
            }
        }

        return subset[subset.length - 1][S];
    }

    public static void main(String[] args) {
//        int[] arr =  {3, 34, 4, 12, 5, 2};
        int[] arr =  {3, 34, 4};
//        System.out.println(new Problems2().rec_subset(arr, arr.length - 1, 9));
//        System.out.println(new Problems2().rec_subset(arr, arr.length - 1, 12));
//        System.out.println(new Problems2().rec_subset(arr, arr.length - 1, 13));
//        System.out.println(new Problems2().rec_subset(arr, arr.length - 1, 14));
//        System.out.println(new Problems2().rec_subset(arr, arr.length - 1, 18));
        System.out.println(new Problems2().rec_subset(arr, arr.length - 1, 7));
        System.out.println(new Problems2().dp_subset(arr, 7));
    }
}
