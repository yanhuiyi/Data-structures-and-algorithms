package com.leetcode.problems;

public class Problems237 {
    private void deleteNode(ListNode node) {
//        node.val = node.next.val;
//        node.next = node.next.next;

        ListNode cur = node, head = new ListNode(0), prev = head;

        while(cur != null) {
            if(node.val == cur.val) {
                prev.next = cur.next;
                cur = null;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        new Problems237().deleteNode(n2);
    }
}
