package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problems109 {
    private List<Integer> values;

    public Problems109() {
        this.values = new ArrayList<Integer>();
    }

    private void mapListToValues(ListNode head) {
        while(head != null) {
            this.values.add(head.val);
            head = head.next;
        }
    }

    private TreeNode convertListToBST(int left, int right) {

        if(left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(this.values.get(mid));

        if(left == right) {
            return node;
        }

        node.left = convertListToBST(left, mid - 1);
        node.right = convertListToBST(mid + 1, right);

        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        this.mapListToValues(head);

        return convertListToBST(0, this.values.size() - 1);
    }

    private ListNode findMiddleElement(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(prev != null)
            prev.next = null;

        return slow;
    }

    public TreeNode sortedListToBST2(ListNode head) {
        if(head == null)
            return null;

        ListNode mid = this.findMiddleElement(head);

        TreeNode node = new TreeNode(mid.val);

        if(head == mid) {
            return node;
        }

        node.left = this.sortedListToBST2(head);
        node.right = this.sortedListToBST2(mid.next);
        return node;
    }

    public static void main(String[] args) {
        int[] values = new int[] {-10,-3,0,5,9};
        ListNode head = new ListNode(-10);
        ListNode cur = head;

        for(int i = 1; i < values.length; i++) {
            ListNode node = new ListNode(values[i]);
            cur.next = node;
            cur = node;
        }

        System.out.println(new Problems109().sortedListToBST(head));
        System.out.println(new Problems109().sortedListToBST2(head));
    }
}
