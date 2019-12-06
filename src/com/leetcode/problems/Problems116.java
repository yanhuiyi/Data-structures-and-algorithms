package com.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Problems116 {
//    public static Node connect(Node root) {
//        if(root == null) {
//            return null;
//        }
//
//        Queue<Node> queue = new LinkedList<>();
//
//        queue.offer(root);
//
//        while(!queue.isEmpty()) {
//            Node leadingNode = null;
//            int size = queue.size();
//
//            for(int i = 0; i < size; i++) {
//                Node node = queue.poll();
//
//                leadingNode = node;
//                node.next = leadingNode;
//
//                if(node.right != null) {
//                    queue.offer(node.right);
//                }
//
//                if(node.left != null) {
//                    queue.offer(node.left);
//                }
//            }
//
//        }
//
//        return root;
//    }

    public Node connect(Node root) {
        if(root == null) return null;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            Node tail = null;

            for(int i = 0; i < size; i++) {
                Node node = queue.poll();
                node.next = tail;
                tail = node;

                if(node.right != null)
                    queue.offer(node.right);

                if(node.left != null)
                    queue.offer(node.left);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node leaf4 = new Node(4, null, null, null);
        Node leaf5 = new Node(5, null, null, null);
        Node leaf2 = new Node(2, leaf4, leaf5, null);

        Node leaf6 = new Node(6, null, null, null);
        Node leaf7 = new Node(7, null, null, null);
        Node leaf3 = new Node(3, leaf6, leaf7, null);


        Node root = new Node(1, leaf2, leaf3, null);

        System.out.println(new Problems116().connect(root));
    }
}
