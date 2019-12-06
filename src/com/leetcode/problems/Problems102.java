package com.leetcode.problems;

import java.util.*;

public class Problems102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode leftChild = new TreeNode(9);
        TreeNode rightChild = new TreeNode(20);

        rightChild.left = new TreeNode(15);
        rightChild.right = new TreeNode(7);

        root.left = leftChild;
        root.right = rightChild;

        System.out.println(new Problems102().levelOrder(root));
    }
}
