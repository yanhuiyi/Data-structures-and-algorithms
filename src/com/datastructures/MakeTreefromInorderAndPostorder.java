package com.datastructures;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class MakeTreefromInorderAndPostorder {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return construct(inorder, postorder, 0, postorder.length - 1, postorder.length - 1);
    }

    public static TreeNode construct(int[] inorder, int[] postorder, int start, int end, int postorderIndex) {
        if(start > end) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorderIndex]);
        postorderIndex--;

        if(start == end) {
            return root;
        }

        int inorderIndex = getInorderIndex(inorder, start, end, root.val);

        root.right = construct(inorder, postorder, inorderIndex + 1, end, postorderIndex);
        root.left = construct(inorder, postorder, start, inorderIndex - 1, postorderIndex);

        return root;
    }

    public static int getInorderIndex(int[] inorder, int start, int end, int data) {
        for(int i = start; i <= end; i++) {
            if(data == inorder[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }
}