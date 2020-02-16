package com.leetcode.problems;

import com.huwawei.interview.Problems1;

import java.util.List;

public class Problems92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode result = head;
        ListNode preHead = null;
        ListNode newHead = null;

        int i = 0;
        while (i < m - 1) {
            preHead = head;
            head = head.next;
            i++;
        }

        ListNode modifyListTail = head;

        int len = n - m + 1;
        int j = 0;

        while(head != null && j < len) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
            j++;
        }

        modifyListTail.next = head;

        if(preHead != null) {
            preHead.next = newHead;
        } else {
            result = newHead;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;

        System.out.println(new Problems92().reverseBetween(head, 1, 4));

        head = new ListNode(3);
        head.next = new ListNode(5);

        System.out.println(new Problems92().reverseBetween(head, 1, 2));
    }
}
