package com.leetcode.problems;

import org.w3c.dom.CDATASection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Problems160 {
    /**
     * Iterate list with set comparision
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

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

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB)  {
        int listALen = getListLength(headA);
        int listBLen = getListLength(headB);

        if(listALen > listBLen)
            headA = forwardLongList(listALen, listBLen, headA);
        else
            headB = forwardLongList(listBLen, listALen, headB);

        while (headA != null && headB != null) {
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int getListLength(ListNode head) {
        int len = 0;
        while (head != null) {
           len++;
           head = head.next;
        }
        return len;
    }

    private ListNode forwardLongList(int longLen, int shortLen, ListNode head) {
        int delta = longLen - shortLen;
        while (head != null && delta > 0) {
           head = head.next;
           delta--;
        }
        return head;
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
        System.out.println(new Problems160().getIntersectionNode2(headA, headB));
    }
}
