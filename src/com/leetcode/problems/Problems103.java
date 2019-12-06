package com.leetcode.problems;

import java.util.*;

public class Problems103 {
//    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> list = new ArrayList<>();
//        Stack<TreeNode> stack1 = new Stack<>();
//        Stack<TreeNode> stack2 = new Stack<>();
//
//        stack1.push(root);
//
//        while(!stack1.isEmpty() || !stack2.isEmpty()) {
//
//            List<Integer> elem = new ArrayList<>();
//
//            while(!stack1.isEmpty()) {
//                TreeNode node = stack1.pop();
//                elem.add(node.val);
//                if(node.left != null) {
//                    stack2.push(node.left);
//                }
//                if(node.right != null) {
//                    stack2.push(node.right);
//                }
//            }
//            list.add(elem);
//
//            elem = new ArrayList<>();
//
//            while (!stack2.isEmpty()) {
//                TreeNode node = stack2.pop();
//                elem.add(node.val);
//                if(node.right != null) {
//                    stack1.push(node.right);
//                }
//                if(node.left != null) {
//                    stack1.push(node.left);
//                }
//            }
//            if(!elem.isEmpty()) {
//                list.add(elem);
//            }
//        }
//        return list;
//    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.add(root);

        while(!s1.isEmpty() || !s2.isEmpty()) {

            List<Integer> level = new ArrayList<>();

            while (!s1.isEmpty()) {
                TreeNode node = s1.pop();
                level.add(node.val);

                if(node.left != null) s2.add(node.left);
                if(node.right != null) s2.add(node.right);
            }

            ans.add(level);

            level = new ArrayList<>();

            while (!s2.isEmpty()) {
                TreeNode node = s2.pop();
                level.add(node.val);

                if(node.left != null) s1.add(node.left);
                if(node.right != null) s1.add(node.right);
            }

            if(!level.isEmpty()){
                ans.add(level);
            }
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

        System.out.println(new Problems103().zigzagLevelOrder(root));
    }
}
