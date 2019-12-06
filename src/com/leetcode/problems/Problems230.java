package com.leetcode.problems;

import java.util.Stack;

public class Problems230 {
//    public static int kthSmallest(TreeNode root, int k) {
//        if(root == null) {
//            return -1;
//        }
//        List<Integer> list = new ArrayList<>();
//        helper(root, list);
//        return list.get(k);
//    }
//
//    public static void helper(TreeNode node, List<Integer> list) {
//        if(node != null) {
//            helper(node.left, list);
//            list.add(node.val);
//            helper(node.right, list);
//        }
//    }

    public int kthSmallest(TreeNode root, int k) {
        int minValue = -1;
        if(root == null) return minValue;

        Stack<TreeNode> stack = new Stack<>();
        int i = 0;

        while ((!stack.isEmpty() || root != null) && i < k) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            minValue = root.val;
            root = root.right;
            ++i;
        }
        return minValue;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode leftChild = new TreeNode(7);
        TreeNode rightChild = new TreeNode(8);

        leftChild.left = new TreeNode(4);
        leftChild.right = new TreeNode(6);

        leftChild.left.left = new TreeNode(1);

        root.left = leftChild;
        root.right = rightChild;

//        TreeNode root = new TreeNode(3);
//        TreeNode leftChild = new TreeNode(1);
//        TreeNode rightChild = new TreeNode(4);
//
////        leftChild.left = new TreeNode(2);
//        leftChild.right = new TreeNode(2);
////
////        leftChild.left.left = new TreeNode(1);

        root.left = leftChild;
        root.right = rightChild;


        System.out.println(new Problems230().kthSmallest(root, 3));
    }
}
