package com.datastructures.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Preparation: generate a list contains [[1], [1, 2], [1, 2, 3]]
 * with repetitive ways. (loop logic)
 */
public class Problems2 {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3));

        List<Integer> item = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.size(); i++) {
            item.add(nums.get(i));
            // result.add(item) will generate three arrays of [1, 2, 3] for item referencing the same object
            result.add(new ArrayList<>(item));
        }

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++)
                System.out.printf("%4s", result.get(i).get(j));
            System.out.println();
        }
    }
}
