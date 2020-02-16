package com.leetcode.problems;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Problems160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        Set<ListNode> setB = new HashSet<>();

        while(headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while(headB != null) {
            if(set.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(4);

        ListNode headB = new ListNode(3);

        headA.next = a;
        a.next = b;
        b.next = c;

        headB.next = c;
        c.next = d;

        System.out.println(new Problems160().getIntersectionNode(headA, headB));
    }
}
