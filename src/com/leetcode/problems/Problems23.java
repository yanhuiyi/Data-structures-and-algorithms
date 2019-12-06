package com.leetcode.problems;

import java.util.PriorityQueue;

public class Problems23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length - 1);
    }

    public ListNode sort(ListNode[] lists, int low, int high) {
        if(low >= high) return lists[low];
        int mid = (high - low) / 2 + low;
        ListNode l1 = sort(lists, low, mid);
        ListNode l2 = sort(lists, mid + 1, high);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if (l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        l2.next = merge(l1, l2.next);
        return l2;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if(cur.next != null) {
                queue.add(cur.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] values = new int[] {1, 4, 5};
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

        values = new int[] {2, 6};
        ListNode l3 = new ListNode(2);
        cur = l3;

        for(int i = 1; i < values.length; i++) {
            ListNode node = new ListNode(values[i]);
            cur.next = node;
            cur = node;
        }


        System.out.println(new Problems23().mergeKLists2(new ListNode[]{l1, l2, l3}));
    }
}
