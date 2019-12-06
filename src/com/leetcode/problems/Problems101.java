package com.leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problems101 {
    public static List<Integer> list = new ArrayList<>();

    public static List<Integer> preorderList = new ArrayList<>();
    public static List<Integer> postorderList = new ArrayList<>();

//    public static boolean isSymmetric(TreeNode root) {
//        preorder(root);
//        postorder(root);
//
//        if(preorderList.size() != postorderList.size()) {
//            return false;
//        }
//
//        for(int i = 0; i < preorderList.size(); i++) {
//            if(preorderList.get(i) != postorderList.get(i)) {
//                return false;
//            }
//        }
//        return true;
//    }

    public static void preorder(TreeNode node) {
        if(node != null) {
            preorderList.add(node.val);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public static void postorder(TreeNode node) {
        if(node != null) {
            postorder(node.left);
            postorder(node.right);
            postorderList.add(node.val);
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();

            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;

            if(t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode leftChild = new TreeNode(2);
        TreeNode rightChild = new TreeNode(2);

        leftChild.left = new TreeNode(2);
        leftChild.right = null;

        rightChild.left = new TreeNode(2);
        rightChild.right = null;

        root.left = leftChild;
        root.right = rightChild;

        root = new TreeNode(2);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(3);

        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);

        TreeNode e = new TreeNode(4);

        root.left = a;
        root.right = b;

        a.left = c;
        a.right = d;

        b.right = e;

        System.out.println(new Problems101().isSymmetric(root));
    }
}
