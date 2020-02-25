package com.datastructures.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * The same output with com.datastructures.backtrace.Problems2
 * with implementation of backtrace
 */
public class Problems1 {

    public void generate(int i, List<Integer> nums, List<Integer> item, List<List<Integer>> result) {
       if(i >= nums.size())
           return;

       item.add(nums.get(i));
       result.add(new ArrayList<>(item));
       generate(i + 1, nums, item, result);
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);

        List<Integer> item = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        new Problems1().generate(0, nums, item, result);
        for(int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++)
                System.out.printf("%4s", result.get(i).get(j));
            System.out.println();
        }
    }
}
