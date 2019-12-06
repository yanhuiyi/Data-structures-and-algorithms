package com.leetcode.problems;

public class Problems236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null)
            return root;

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

//        TreeNode p = new TreeNode(5);
//        TreeNode q = new TreeNode(1);
//
//        TreeNode c = new TreeNode(2);
//
//        root.left = p;
//        root.right = q;
//
//        p.left = new TreeNode(6);
//        p.right = c;
//
//        c.left = new TreeNode(7);
//        c.right = new TreeNode(4);
//
//        q.left = new TreeNode(0);
//        q.right = new TreeNode(8);

        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(1);

        TreeNode c = new TreeNode(2);
        TreeNode p = new TreeNode(7);
        TreeNode q = new TreeNode(4);

        root.left = a;
        root.right = b;

        a.left = new TreeNode(6);
        a.right = c;

        c.left = p;
        c.right = q;

        b.left = new TreeNode(0);
        b.right = new TreeNode(8);

        TreeNode ans = new Problems236().lowestCommonAncestor(root, p, q);
        System.out.println(ans);
    }
}
