package com.leetcode.problems;

import java.util.*;

public class Problems752 {
    public int openLock(String[] deadends, String target) {
        List<String> deadlocks = Arrays.asList(deadends);
        if(deadlocks.contains("0000"))
            return -1;

        int count = 0;

        Set<String> visited = new HashSet<>();
        visited.add("0000");

        LinkedList<String> queue = new LinkedList<>();
        queue.add("0000");

        while (!queue.isEmpty()) {
            count++;

            for(int k = queue.size(); k > 0; --k) {
                String cur = queue.poll();
                for(int i = 0; i < cur.length(); i++) {
                    for(int j = -1; j <=1; j++) {
                        if(j == 0) continue;
                        StringBuilder str = new StringBuilder(cur);
                        str.setCharAt(i, (char)(((cur.charAt(i) - '0') + 10 + j) % 10 + '0'));
                        if(str.toString().equals(target))
                            return count;
                        if(!visited.contains(str.toString()) && !deadlocks.contains(str.toString()))
                            queue.add(str.toString());
                        visited.add(str.toString());
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Problems752().openLock(new String[]{"8888"}, "9000"));
        System.out.println(new Problems752().openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
        System.out.println(new Problems752().openLock(new String[]{"8888"}, "0009"));
        System.out.println(new Problems752().openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
        System.out.println(new Problems752().openLock(new String[]{"0000"}, "8888"));

        LinkedList<String> stack = new LinkedList<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack);

        LinkedList<String> queue = new LinkedList<>();
        queue.add("A");
        queue.add("B");
        queue.add("C");

        System.out.println(queue);
    }
}
