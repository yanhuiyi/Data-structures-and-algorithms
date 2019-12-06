package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;



public class Problems1022 {

    private String sumRootToLeaf(TreeNode root, StringBuilder sb) {

        if(root == null) {
            return "";
        }

        sb.append(root.val);

        if(root.left == null || root.right == null)
            return sb.toString();

        return sumRootToLeaf(root.left, sb).concat(" ").concat(sumRootToLeaf(root.right, sb));

    }

    private void preorder(TreeNode root, String s, List<String> list) {
        if(root == null) {
            return;
        }

        s = s + Integer.toString(root.val);

        if(root.left == null && root.right == null) {
//            System.out.println(s);
            list.add(s);
            return;
        }
//        System.out.println(root.val);
//        sb.append(root.val);

        preorder(root.left, s, list);
        preorder(root.right, s, list);
    }

    private int sumRootToLeaf(TreeNode root, int sum) {

        if(root == null) {
            return 0;
        }

        sum = 2 * sum + root.val;
        if(root.left == null && root.right == null) {

            return sum;
        }

        return sumRootToLeaf(root.left, sum) + sumRootToLeaf(root.right, sum);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);

        root.left = a;
        root.right = b;

        a.left = new TreeNode(0);
        a.right = new TreeNode(1);

        b.left = new TreeNode(0);
        b.right = new TreeNode(1);

        List<String> list = new ArrayList<>();
        new Problems1022().preorder(root, "", list);
        int sum = 0;
        for(String s : list) {
//            System.out.println(s);
            sum += Integer.parseInt(s, 2);
        }
//        System.out.println(sum);

        System.out.println(new Problems1022().sumRootToLeaf(root, 0));
    }
}
