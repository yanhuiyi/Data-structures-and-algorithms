package com.leetcode.problems;

public class Problems104 {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode a = new TreeNode(9);
        TreeNode b = new TreeNode(20);

        root.left = a;
        root.right = b;

        b.left = new TreeNode(15);
        b.right = new TreeNode(7);

        System.out.println(new Problems104().maxDepth(root));
    }
}
