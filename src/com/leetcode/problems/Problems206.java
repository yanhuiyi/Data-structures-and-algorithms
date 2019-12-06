package com.leetcode.problems;

class ListNode {
   int val;
   ListNode next;
   ListNode(int x) { val = x; }
}

public class Problems206 {

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {

        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);

        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = null;

        System.out.println(reverseList(ln1));
    }
}
