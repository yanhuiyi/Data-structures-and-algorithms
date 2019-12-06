package com.datastructures;

public class InsertionSort {

    public static void insertionSort(int[] a) {
        // int[] a = {5, 14, 12, 3, 9, 19};
        // {5, 12, 14, 3, 9, 19}
        for (int i = 1; i < a.length; i++) {
            int target = a[i];
            int p = i - 1;
            boolean found = false;

            while (p >= 0 && !found) {
                if (a[p] <= target) {
                    found = true;
                } else {
                    p = p - 1;
                }
            }

            p = p + 1;

            for (int k = i - 1; found && k >= p; k--) {
                a[k + 1] = a[k];
            }
            a[p] = target;
        }
    }

    public static void insertionSort2(int[] a) {
        //  int[] a = {5, 14, 12, 3, 9, 19};

        for(int i = 1; i < a.length; i++) {
            int target = a[i];

            int j = i - 1;
            while (j >= 0 && target < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1]  = target;

        }
    }

    public static void main(String[] args) {
        int[] a = {5, 14, 12, 3, 9, 19};
        int[] a2 = {3, 5, 9, 12, 14, 19 };
        for (int elem : a2) {
            System.out.printf("%s ", elem);
        }

        System.out.println();

        // Insertion sort
        insertionSort2(a);

        int i = 0;
        while(i < a.length) {
            System.out.printf("%s ", a[i]);
            i++;
        }
    }
}
