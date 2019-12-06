package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

 class RandomNode {
    public int val;
    public RandomNode next;
    public RandomNode random;

    public RandomNode(int _val) {
        val = _val;
    }

    public RandomNode(int _val,RandomNode _next,RandomNode _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};

public class Problems138 {
    public RandomNode copyRandomList(RandomNode head) {
        Map<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode cur = head;

        while(cur != null) {
            map.put(cur, new RandomNode(cur.val));
            cur = cur.next;
        }

        cur = head;
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
       RandomNode n1 = new RandomNode(1);
       RandomNode n2 = new RandomNode(2);
       n1.next = n2;
       n1.random = n2;

       n2.next = null;
       n2.random = n2;

        System.out.println(new Problems138().copyRandomList(n1));
    }
}
