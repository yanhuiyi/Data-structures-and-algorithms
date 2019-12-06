package com.leetcode.problems;

public class Problems124 {

//    public static int maxPathSum(TreeNode root) {
//        int maxValue = -Integer.MAX_VALUE;
//        return helper(root);
//    }
//
//    public static int helper(TreeNode root) {
//        int maxValue = 0;
//        int sum = 0;
//
//        if(root == null) {
//            return maxValue;
//        }
//
//        Stack<TreeNode> stack = new Stack<>();
//
//        TreeNode node = root;
//
//        while (node != null || !stack.isEmpty()) {
//            while (node != null) {
//                stack.push(node);
//                node = node.left;
//            }
//            node = stack.pop();
//            sum = sum + node.val;
//            if(sum > maxValue) {
//                maxValue = sum;
//            }
//
//            node = node.right;
//        }
//
//        return maxValue;
//    }

    static int max = Integer.MIN_VALUE;

    public static int maxPathSum2(TreeNode root) {
        helper(root);
        return max;
    }

    // helper returns the max branch
    // plus current node's value
    static int helper(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        max = Math.max(max, root.val + left + right);

        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;

        int[] maxValue = new int[] {Integer.MIN_VALUE};
        dfs(root, maxValue);
        return maxValue[0];
    }

    private int dfs(TreeNode root, int[] maxValue) {
        int left = root.left != null ? Math.max(dfs(root.left, maxValue), 0) : 0;
        int right = root.right != null ? Math.max(dfs(root.right, maxValue), 0) : 0;
        int cur = root.val + left + right;
        maxValue[0] = Math.max(maxValue[0], cur);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(-10);
//        TreeNode leftChild = new TreeNode(9);
//        TreeNode rightChild = new TreeNode(20);
//
//        rightChild.left = new TreeNode(15);
//        rightChild.right = new TreeNode(7);
//
//        root.left = leftChild;
//        root.right = rightChild;

        TreeNode root = new TreeNode(1);
        TreeNode leftChild = new TreeNode(2);
        TreeNode rightChild = new TreeNode(-3);

        root.left = leftChild;
        root.right = rightChild;

//        System.out.println(maxPathSum2(root));
        System.out.println(new Problems124().maxPathSum(root));
    }

}







