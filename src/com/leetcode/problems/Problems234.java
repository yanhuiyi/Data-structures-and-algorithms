package com.leetcode.problems;

import java.util.Stack;

public class Problems234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        ListNode slow = head, fast = head;
        Stack<Integer> stack = new Stack<>();

        while(fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null)
            slow = slow.next;

        while(slow != null) {
            int val = stack.pop();
            if(val != slow.val)
                return false;
            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] values = new int[] {1, 2, 3, 2, 1};
        ListNode head = new ListNode(1);
        ListNode cur = head;

        for(int i = 1; i < values.length; i++) {
            ListNode node = new ListNode(values[i]);
            cur.next = node;
            cur = node;
        }

        System.out.println(new Problems234().isPalindrome(head));

    }
}
