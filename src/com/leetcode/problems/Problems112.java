package com.leetcode.problems;

public class Problems112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null && root.val == sum)
            return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(8);
        b.left = new TreeNode(13);

        TreeNode c = new TreeNode(11);
        c.left = new TreeNode(7);
        c.right = new TreeNode(2);

        TreeNode d = new TreeNode(4);
        d.right = new TreeNode(1);

        root.left = a;
        root.right = b;

        a.left = c;

        System.out.println(new Problems112().hasPathSum(root, 22));
    }
}
