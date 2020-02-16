package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problems86 {
    private ListNode getPartList(List<ListNode> list) {
        ListNode head = list.remove(0);
        ListNode cur = head;
        while (list.size() > 0) {
            cur.next = list.remove(0);
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return null;

        ListNode lessHead = new ListNode(0);
        ListNode moreHead = new ListNode(0);
        ListNode lessPtr = lessHead;
        ListNode morePtr = moreHead;

        while (head != null) {
            if(head.val < x) {
                lessPtr.next = head;
                lessPtr = lessPtr.next;
            } else {
                morePtr.next = head;
                morePtr = morePtr.next;
            }
            head = head.next;
        }

        lessPtr.next = moreHead.next;
        morePtr.next = null;

        return lessHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(2);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(new Problems86().partition(head, 3));

        head = new ListNode(1);
        System.out.println(new Problems86().partition(head, 0));

        head = new ListNode(2);
        a = new ListNode(4);
        b = new ListNode(6);
        c = new ListNode(7);

        head.next = a;
        a.next = b;
        b.next = c;

        System.out.println(new Problems86().partition(head, 1));

        System.out.println(new Problems86().partition(head, 8));
    }
}
