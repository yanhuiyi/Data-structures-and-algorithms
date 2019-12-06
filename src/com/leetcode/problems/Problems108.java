package com.leetcode.problems;

public class Problems108 {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }
//
// My original problems
//    public static TreeNode buildTree(int[] nums, int start, int end) {
//        int mid = (start + end) / 2;
//        TreeNode node = new TreeNode(nums[mid]);
//
//        Return point is not correct why it should be if(start > end)
//        if(start == mid) {
//            return node;
//        }
//
//        node.left = buildTree(nums, start, mid);
//        node.right = buildTree(nums, mid, end);
//
//        return node;
//    }

    public static TreeNode buildTree(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = buildTree(nums, start, mid - 1);
        node.right = buildTree(nums, mid + 1, end);

        return node;
    }


    private TreeNode _buildBST(int[] nums, int start, int end) {
        if(start > end) return null;

        int mid = (end - start) / 2 + start;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = _buildBST(nums, start, mid - 1);
        root.right = _buildBST(nums, mid + 1, end);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.println(root);

        int[] array = {-10, -3, 0, 5, 9};
        TreeNode node = new Problems108()._buildBST(array, 0, array.length - 1);
        System.out.println(node);
    }
}
