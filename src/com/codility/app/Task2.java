package com.codility.app;

import java.util.ArrayList;

public class Task2 {
    public String[] solution(int N, int K) {
        if (N == 0) {
            return new String[] {""};
        }
        ArrayList<String> result = new ArrayList<String>();
        String[] temp = solution(N - 1, K - 1);
        for (String p : temp) {
            for (char l : new char[] {'a', 'b', 'c'}) {
                int pLen = p.length();
                if (pLen == 0 || p.charAt(pLen - 1) != l) {
                    result.add(p + l);
                }
            }
        }
        int prefSize = Math.min(result.size(), K);
        return result.subList(0, prefSize).toArray(new String[prefSize]);
    }

    public static void main(String[] args) {
        String[] ans = new Task2().solution(4,4);
//        String[] ans2 = new Task2().solution(5,20);
//        System.out.println(ans.toString());
//        System.out.println(ans2.toString());
    }
}
