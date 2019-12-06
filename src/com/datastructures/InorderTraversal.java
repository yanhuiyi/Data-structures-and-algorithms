package com.datastructures;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List <Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public static void helper(TreeNode root, List <Integer> res) {
        if(root != null) {
            if(root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if(root.right != null) {
                helper(root.right, res);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        TreeNode leftChild = new TreeNode(7);
        TreeNode rightChild = new TreeNode(20);

        leftChild.left = new TreeNode(3);
        leftChild.right = new TreeNode(9);

        root.left = leftChild;
        root.right = rightChild;

        List<Integer> list = inorderTraversal(root);
        System.out.println(list);
    }

}
