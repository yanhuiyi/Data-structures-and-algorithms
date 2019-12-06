package com.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Main {
     static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    static <T> Node<T> split(Node<T> L) {
         if(L == null || L.next == null) {
             return null;
         }
         Node<T> first = L;
         Node<T> second = L.next;
         Node<T> restEven = second.next;
         Node<T> restOdd = split(restEven);
         first.next = restEven;
         second.next = restOdd;
//         return L;
        return null;
    }

    public static void main(String[] args) {
	// write your code here
        Node<Integer> node = new Node<Integer>(8, null);
        Node<Integer> node1 = new Node<Integer>(6, node);
        Node<Integer> node2 = new Node<Integer>(9, node1);
        Node<Integer> node3 = new Node<Integer>(2, node2);
        Node<Integer> node4 = new Node<Integer>(5, node3);

//        Node<Integer> cur = node4;

//        while(cur != null) {
//            System.out.printf("%s ", cur.data);
//            cur = cur.next;
//        }


        List<StringBuilder> rows = new ArrayList<>();


        Node<Integer> cur1 = Main.split(node4);

        cur1 = node4;

        while(cur1 != null) {
            System.out.printf("%s ", cur1.data);
            cur1 = cur1.next;
        }

    }
}
