package com.datastructures;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */



public class MaximumDepthOfBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int maxDepth(TreeNode root) {
        int leftDepth = 0;
        int rightDepth = 0;

        if(root == null) {
            return 0;
        }

        leftDepth = maxDepth(root.left);

        rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        TreeNode rNode = new TreeNode(20);
        rNode.left = new TreeNode(15);
        rNode.right = new TreeNode(7);

        root.right =  rNode;

        System.out.println(maxDepth(root));
    }
}
