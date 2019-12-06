package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problems94 {

    public List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            list.add(cur.val);

            // My original problems
//            if(cur.right != null) {
//                stack.push(cur.right);
//            }
            cur = cur.right;

        }



        return list;
    }


}
