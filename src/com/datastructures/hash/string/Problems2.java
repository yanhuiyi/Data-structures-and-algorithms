package com.datastructures.hash.string;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
       val = x;
       next = null;
    }
}
public class Problems2 {
    private int hashFunction(int key, int tableLen) {
        return key % tableLen;
    }

    private void insert(ListNode[] hashTable, ListNode node, int tableLen) {
        int hashKey = hashFunction(node.val, tableLen);

        node.next = hashTable[hashKey];

        hashTable[hashKey] = node;
    }

    private boolean search(ListNode[] hashTable, int value, int tableLen) {
        int hashKey = hashFunction(value, tableLen );

        ListNode head = hashTable[hashKey];

        while (head != null) {
           if(value == head.val) {
               return true;
           }
           head = head.next;
        }
        return false;
    }


    public static void main(String[] args) {

    }

}
