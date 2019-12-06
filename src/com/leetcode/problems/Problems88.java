package com.leetcode.problems;

public class Problems88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0)
            for(int i = 0; i < nums1.length; i++)
                nums1[i] = nums2[i];

        int i = m - 1, j = n - 1;
        int len = nums1.length;
        int k = len - 1;

        while(i >= 0 && j >= 0) {
            if(nums1[i] < nums2[j])  {
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }
            k--;
        }

        while(j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 5, 6,0,0,0};
        int[] nums2 = {1, 2, 3};

       new Problems88().merge(nums1, 3, nums2, 3);
       for(int i : nums1)
           System.out.printf("%s ", i);
    }
}
