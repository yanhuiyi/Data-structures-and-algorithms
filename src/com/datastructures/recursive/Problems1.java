package com.datastructures.recursive;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}
/**
 * Push node'val pointed by head into vector or array.
 */
public class Problems1 {

    public void addToVector(ListNode head, List vector) {
        if(head == null)
            return;

        addToVector(head.next, vector);
        vector.add(head.val);
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
        List<Integer> list = new ArrayList<>();
        new Problems1().addToVector(head, list);
        System.out.println(list);
    }
}
