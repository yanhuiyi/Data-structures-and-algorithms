package com.datastructures.hash.string;

import java.util.Arrays;

/**
 * Sort positive integer array with hashtable
 */
public class Problems1 {

    public static void main(String[] args) {
        int[] random = {999, 1, 444, 7, 20, 9, 1, 3, 7, 7};
        int[] hashmap = new int[1000];
        Arrays.fill(hashmap, 0);

        for(int i = 0; i < random.length; i++)
            hashmap[random[i]]++;

        for(int i = 0; i < hashmap.length; i++)
            for(int j = 0; j < hashmap[i]; j++)
                System.out.printf("%d\n", i);
    }
}
