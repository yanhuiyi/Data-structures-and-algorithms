package com.leetcode.problems;

import java.util.Stack;

public class Problems98 {

    public boolean isValidBST(TreeNode root, long min, long max) {
        if(root == null) return true;

        if(root.val < min || root.val > max) return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    private boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long min = - Long.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if(root.val <= min) {
                return false;
            } else {
                min = root.val;
            }
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(3);

        root.left = a;
        root.right = b;

        System.out.println(new Problems98().isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(new Problems98().isValidBST(root));

        root = new TreeNode(5);
        a = new TreeNode(1);
        b = new TreeNode(4);

        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(6);

        root.left = a;
        root.right = b;

        b.left = c;
        b.right = d;

        System.out.println(new Problems98().isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(new Problems98().isValidBST(root));
    }
}
