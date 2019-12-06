package com.datastructures;

public class FindMedianSortedArrays {

    public static double rearrange(int[] nums1, int[] nums2) {
        int i, j, k;
        int[] nums3 = new int[nums1.length  + nums2.length];

        // Copy nums1 to nums3
//        for(i = 0; i < nums1.length; i++) {
//            nums3[i] = nums1[i];
//        }
//
//        for(i = 0; i < nums2.length; i++) {
//            x = nums2[i];
//            j = nums1.length - 1;
//            while(j > i && x < nums1[j]) {
//                nums3[j + 1] = nums3[j];
//                j--;
//            }
//            nums3[j + 1] = x;
//        }
//        return nums3;
        i = 0;
        j = 0;
        k = 0;

        while (i < nums1.length && j < nums2.length) {
            if(nums1[i] <= nums2[j]) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }

        }

        if(i < nums1.length) {
            while(i < nums1.length) {
                nums3[k++] = nums1[i++];
            }
        }

        if(j < nums2.length) {
            while(j < nums2.length) {
                nums3[k++] = nums2[j++];
            }
        }

        double medium = 0.0;

        if(nums3.length % 2 == 1) {
            // Odd number
            medium = nums3[nums3.length / 2];
        } else {
            medium = (nums3[nums3.length / 2 - 1] + nums3[nums3.length / 2]) / 2.0;
        }

        return  medium;
    }

    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 6, 7, 10};
//        int[] nums2 = {3, 4, 20, 23};
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        int a = 1;
        Integer b = 1;

        Boolean t = false;
        boolean t2 = false;

        System.out.println(t == t2);
        System.out.println(b.equals(a));

        double medium = rearrange(nums1, nums2);
        System.out.printf("%s ", medium);
    }
}
