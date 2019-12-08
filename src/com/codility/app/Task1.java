package com.codility.app;

import java.util.ArrayList;
import java.util.List;
/**
 * Only character 'a', 'b', 'c';
 * Given N=2, K=4 output is: ab, ac, ba, bc
 * Given N=3, K=20 output is: aba, abc, bab, bac, cab, cac, c
 * @param N
 * @param K
 * @return
 */
public class Task1 {
    public int solution(int[] A) {
        List<Integer> list = new ArrayList<>();

        int current = A[0];
        int i = 0;

        while(current != -1) {
            list.add(current);
            current = A[current];
        }

        list.add(current);

        return list.size();
    }

    public static void main(String[] args)  {
        System.out.println(new Task1().solution(new int[]{1, 4, -1, 3, 2}));
        System.out.println(new Task1().solution(new int[]{2, 5, 4, -3, -1, -4, 1}));
        System.out.println(new Task1().solution(new int[]{1, 4, 3, 7, 6, -1, 5, 2}));
    }
}
