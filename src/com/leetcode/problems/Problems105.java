package com.leetcode.problems;

public class Problems105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return _buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode _buildTree(int[] preorder, int preorderStart, int preorderEnd,
                                int[] inorder, int inorderStart, int inorderEnd) {

        if(preorderStart >= preorderEnd)
            return null;

        int i = inorderStart;

        while (i < inorderEnd) {
            if(preorder[preorderStart] == inorder[i])
                break;
            ++i;
        }

        TreeNode root = new TreeNode(preorder[preorderStart]);

        int number = i - inorderStart;

        root.left = _buildTree(preorder, preorderStart + 1, preorderStart + number + 1, inorder, inorderStart, i);
        root.right = _buildTree(preorder, preorderStart + number + 1, preorderEnd, inorder, i + 1, inorderEnd);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = new Problems105().buildTree(preorder, inorder);
        System.out.println(root);
    }

}
