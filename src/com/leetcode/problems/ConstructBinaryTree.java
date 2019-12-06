package com.leetcode.problems;

import java.util.Arrays;
import java.util.stream.Collectors;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; };
    TreeNode(String x) { val = Integer.valueOf(x); };
}

class ConstructBinaryTree {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) {
            return null;
        }

        int rootVal = preorder[0];

        TreeNode node = new TreeNode(rootVal);

        if(inorder.length == 1) {
            return node;
        }

        int pos = Arrays.stream(inorder).boxed().collect(Collectors.toList()).indexOf(rootVal);

        if(pos == 0) {
            node.left = null;
        } else {
            node.left = buildTree(Arrays.copyOfRange(preorder, 1, pos + 1), Arrays.copyOfRange(inorder, 0, pos));
        }

        if(pos == inorder.length - 1) {
            node.right = null;
        } else {
            node.right = buildTree(Arrays.copyOfRange(preorder, pos + 1,  preorder.length), Arrays.copyOfRange(inorder, pos + 1, inorder.length));
        }

        return node;
    }

    public static void main(String[] args) {
        TreeNode node = buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(node);
    }
}