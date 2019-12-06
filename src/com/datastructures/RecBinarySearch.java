package com.datastructures;

public class RecBinarySearch {
    static void recBinarySearch(int[] list, int target, int left, int right) {
        if(left > right) {
            System.out.print("Not found!");
        } else {
            int mid = (left + right) / 2;
            if(target == list[mid]) {
                System.out.printf("Index at %s ", mid);
            } else if(target < list[mid]) {
                recBinarySearch(list, target, left, mid - 1);
            } else {
                recBinarySearch(list, target, mid + 1, right);
            }
        }
    }


    public static void main(String[] args) {
        int[] list = {2, 4, 10, 21, 29, 33, 40, 59};
        recBinarySearch(list, 40, 0, list.length);
    }
}
