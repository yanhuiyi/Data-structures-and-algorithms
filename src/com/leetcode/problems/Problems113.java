package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problems113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null || sum == 0) return ans;

        List<Integer> list = new ArrayList<>();

        backtrace(root, sum, ans, list);
        return ans;
    }

    private void backtrace(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> list) {
        if(root == null)
            return;
        list.add(root.val);

        if(root.left == null && root.right == null && root.val == sum) {
            ans.add(new ArrayList<>(list));
        }

        backtrace(root.left, sum - root.val, ans, list);
        backtrace(root.right, sum - root.val, ans, list);
        list.remove(list.size() - 1);
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
        d.left = new TreeNode(5);

        root.left = a;
        root.right = b;

        a.left = c;

        System.out.println(new Problems113().pathSum(root, 22));
    }
}
