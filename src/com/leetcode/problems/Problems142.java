package com.leetcode.problems;

public class Problems142 {

    ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode meet = null;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            }

            if(fast == slow) {
                meet = fast;
                break;
            }
        }

        while (head != null && meet != null) {
            if (head == meet)
                return head;
            head = head.next;
            meet = meet.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(0);
        ListNode c = new ListNode(-4);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = a;

        System.out.println(new Problems142().detectCycle(head));

        head = new ListNode(1);
        a = new ListNode(2);

        head.next = a;
        a.next = head;

        System.out.println(new Problems142().detectCycle(head));

        head = new ListNode(1);
        head.next = null;

        System.out.println(new Problems142().detectCycle(head));
    }
}
