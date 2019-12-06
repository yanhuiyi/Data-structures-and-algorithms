package com.leetcode.problems;

import java.util.*;

public class Problems347 {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));

        for(int n: map.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
              heap.poll();
            }
        }

        System.out.println(heap);

        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);

        return top_k;
    }

    public static void main(String[] args) {
        topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }

}
