package com.leetcode.problems;

public class Problems19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) {
            return null;
        }

        ListNode cur = head;
        ListNode prevPtr = null, nextPtr = null;
        int length = 0;
        int index = 0;

        while(cur != null) {
            cur = cur.next;
            length++;
        }

        if(n == length) {
            head = head.next;
            return head;
        }

        cur = head;

        while(cur != null) {
            if(index == length - n - 1) {
                prevPtr = cur;
            }
            if(index == length - n) {
                nextPtr = cur.next;
            }
            cur = cur.next;
            index++;
        }

        prevPtr.next = nextPtr;

        return head;
    }

    public static void main(String[] args) {
        int[] values = new int[] {1, 2};
        ListNode head = new ListNode(1);
        ListNode cur = head;

        for(int i = 1; i < values.length; i++) {
            ListNode node = new ListNode(values[i]);
            cur.next = node;
            cur = node;
        }

        System.out.println(new Problems19().removeNthFromEnd(head, 2));
    }
}
