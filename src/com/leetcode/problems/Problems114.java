package com.leetcode.problems;

public class Problems114 {


    public void flatten(TreeNode root) {
        if(root == null)
            return;
//        System.out.println(root.val);

        if(root.left != null) flatten(root.left);
        if(root.right != null) flatten(root.right);

        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;

        while (root.right != null)
            root = root.right;
        root.right = tmp;
    }

    public TreeNode link(TreeNode root, TreeNode cur) {
        if (root == null)
            return null;

        cur.right = root;

        if(root.left == null && root.right == null) {
            return cur;
        }

        cur = root;

        link(root.left, cur);
        link(root.right, cur);
        return cur;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(7);

        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(6);

        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(5);

        TreeNode g = new TreeNode(8);
        TreeNode h = new TreeNode(9);

        root.left = a;
        root.right = b;

        a.left = c;
        a.right = d;

        c.right = e;
        e.right = f;

        b.left = g;
        b.right = h;


       new Problems114().flatten(root);
//        TreeNode head = new TreeNode(0);
//        new Problems114().link(root, head);
    }
}
