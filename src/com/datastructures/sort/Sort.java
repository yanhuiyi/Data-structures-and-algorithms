package com.datastructures.sort;

public class Sort {

    public void quicksort(int[] array, int left, int right) {
        if(left > right) return;

        int pivotal = array[left];
        int i = left;
        int j = right;

        while (i < j) {
            while (pivotal <= array[j] && i < j)
                --j;

            while (pivotal >= array[i] && i < j)
                ++i;

            if(i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        array[left] = array[i];
        array[i] = pivotal;

        quicksort(array, left, i - 1);
        quicksort(array, i + 1, right);
    }

    public static void main(String[] args) {
        int[] array = {3,2,3,1,2,4,5,5,6};

        System.out.printf("Original array:\n");
        for (int i : array)
            System.out.printf(" %s", i);

        new Sort().quicksort(array, 0, array.length - 1);

        System.out.printf("\nQuick sort:\n");
        for(int i : array)
            System.out.printf(" %s", i);
    }
}
