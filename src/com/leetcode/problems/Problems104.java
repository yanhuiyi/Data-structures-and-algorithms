package com.leetcode.problems;

import com.bytedance.string.Problems1;

public class Problems104 {

    private int answer = 0;
    private void maxDepth(TreeNode root, int depth) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            answer = Math.max(answer, depth);
        maxDepth(root.left, depth + 1);
        maxDepth(root.right, depth + 1);
    }
    // Bottom up
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
        Problems104 p = new Problems104();
        p.maxDepth(root, 0);
        System.out.println(p.answer);
    }
}
