package com.leetcode.problems;

public class Problems21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first = l1, second = l2, cur = new ListNode(0);
        ListNode head = cur;

        while(first != null && second != null) {
            cur.next = new ListNode(first.val);
            cur.next.next = new ListNode(second.val);
            first = first.next;
            second = second.next;
            cur = cur.next.next;
        }

        if(first != null) {
            cur.next = first;
        }

        if(second != null) {
            cur.next = second;
        }

        return head.next;
    }

    public static void main(String[] args) {
        int[] values = new int[] {1, 2, 4};
        ListNode l1 = new ListNode(1);
        ListNode cur = l1;

        for(int i = 1; i < values.length; i++) {
            ListNode node = new ListNode(values[i]);
            cur.next = node;
            cur = node;
        }

        values = new int[] {1, 3, 4};
        ListNode l2 = new ListNode(1);
        cur = l2;

        for(int i = 1; i < values.length; i++) {
            ListNode node = new ListNode(values[i]);
            cur.next = node;
            cur = node;
        }

        System.out.println(new Problems21().mergeTwoLists(l1, l2));
    }
}
