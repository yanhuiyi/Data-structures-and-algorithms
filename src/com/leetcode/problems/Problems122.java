package com.leetcode.problems;

public class Problems122 {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;

        if(prices == null || prices.length == 0) return maxprofit;

        int i = 0;
        int valley = prices[0];
        int peak = prices[0];

        while(i < prices.length - 1) {
            while(i < prices.length - 1 && prices[i] > prices[i + 1]) {
                ++i;
            }
            valley = prices[i];
            while(i < prices.length - 1 && prices[i] < prices[i + 1]) {
                ++i;
            }
            peak = prices[i];

            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
//        System.out.println(new Problems122().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new Problems122().maxProfit(new int[]{1, 2, 3, 4, 5}));
    }
}
