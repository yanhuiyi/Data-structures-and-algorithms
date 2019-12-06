package com.leetcode.problems;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int l;
        int r;
        int mid;
        l = 0;
        r = nums.length - 1;

        while(l < r) {
            mid = l + (r - l) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid] < nums[r]) {
                if(nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            if(nums[mid] > nums[l]) {
                if(nums[mid] > target && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return -1;
    }


    public static int search2(int[] arr, int key){
        if(arr.length == 0){
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;

        while (left < right){
            int mid = (right + left) /2;
            if (arr[mid] == key){
                return mid;
            }
            //���ǰ�������
            if (arr[mid] >= arr[left]){
                //�ж�Key�Ƿ���ǰ��Σ�����ڣ����������ǰ��Σ�������ڣ����������
                if (arr[mid] > key && key >= arr[left]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            } else {
                //�ж�Key�Ƿ��ں��Σ�����ڣ�������������Σ�������ڣ������ǰ���
                if (arr[mid] < key && key <= arr[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return arr[left] == key ? left :  -1;
    }

    public static int search3(int[] A, int target) {

        int lo = 0;

        int hi = A.length - 1;

        if (hi < 0)

            return -1;

        while (lo < hi) {

            int mid = (lo + hi) / 2;

            if (A[mid] == target)

                return mid;

            if (A[lo] <= A[mid]) {

                if (target >= A[lo] && target < A[mid])

                    hi = mid - 1;

                else

                    lo = mid + 1;

            } else {

                if (target > A[mid] && target <= A[hi])

                    lo = mid + 1;

                else

                    hi = mid - 1;

            }

        }

        return A[lo] == target ? lo : -1;

    }

    public static void main(String[] args) {
        System.out.println(search2(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
