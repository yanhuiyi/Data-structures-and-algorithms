package com.leetcode.problems;

public class Problems238 {

//    public static int[] productExceptSelf(int[] nums) {
//        int[] result = new int[nums.length];
//        for (int i = 0, tmp = 1; i < nums.length; i++) {
//            result[i] = tmp;
//            tmp *= nums[i];
//        }
//        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
//            result[i] *= tmp;
//            tmp *= nums[i];
//        }
//        return result;
//    }

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        for (int j = nums.length - 1; j > 0; j--) {
            res[j] *= res[0];
            res[0] *= nums[j];
        }
        return res;
    }

    public static int[] productExceptSelf2(int[] nums) {
        final int[] result = new int[nums.length];
        final int[] left = new int[nums.length];
        final int[] right = new int[nums.length];

        left[0] = 1;
        right[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; ++i) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; --i) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        for (int i = 0; i < nums.length; ++i) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

    public static int[] productExceptSelf3(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;

        for(int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int[] right = new int[nums.length];

//        right[nums.length - 1] = 1;
//
//        for(int i = nums.length - 2; i >= 0; i--) {
//            right[i] = right[i + 1] * nums[i + 1];
//        }

        int right2 = 1;

        for(int i = nums.length - 1; i >=0; i--) {
            ans[i] = ans[i] * right2;
            right2 = right2 * nums[i];
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] ret = productExceptSelf2(new int[]{1, 2, 3, 4});
        for (int val : ret) {
            System.out.printf("%s ", val);
        }

    }
}
