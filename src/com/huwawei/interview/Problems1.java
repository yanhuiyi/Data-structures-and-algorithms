package com.huwawei.interview;

import com.sun.source.tree.Tree;

import javax.swing.*;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; };
}

public class Problems1 {

    /**
     * Construct binary tree from given input string separated by comma by level order
     * @param s Given string represents tree nodes in level order
     * @return TreeNode constructed by level order
     */
    public TreeNode constructFromString(String s) {
        if(s == null || s.trim().length() == 0) {
            System.out.println("A comma separated string number required.  Example: 10,5,12,4,7");
            return null;
        }

        String delimiter = ",";
        String[] ss = s.split(delimiter);

        int[] n = new int[ss.length];

        try {
            for (int i = 0; i < ss.length; i++) {
                n[i] = Integer.parseInt(ss[i].trim());
            }
        } catch (NumberFormatException exception) {
            throw exception;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        int index = 0;
        int len = n.length;

        TreeNode root = new TreeNode(n[index]);
        queue.offer(root);

        while (!queue.isEmpty()) {
             TreeNode node = queue.poll();
             if(++index < len) {
                 TreeNode left = new TreeNode(n[index]);
                 queue.offer(left);
                 node.left = left;
             }
             if(++index < len) {
                 TreeNode right = new TreeNode(n[index]);
                 queue.offer(right);
                 node.right = right;
             }
        }
        return root;
    }

    /**
     *  Get all root to leaf paths when path sum equals the given sum
     * @param root TreeNode root of the binary tree
     * @param sum Given sum
     * @return List of paths' node
     */
    public List<List<Integer>> getSumPath(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        List<Integer> list = new ArrayList<>();

        backtrace(root, sum, ans, list);
        return ans;
    }

    private void backtrace(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> list) {
        if(root == null)
            return;
        list.add(root.val);

        if(root.left == null && root.right == null && root.val == sum) {
            ans.add(new ArrayList<>(list));
        }

        backtrace(root.left, sum - root.val, ans, list);
        backtrace(root.right, sum - root.val, ans, list);
        list.remove(list.size() - 1);
    }

    /**
     * Format print result; print 'error' if empty result returned
     * @param lists List of result
     */
    public void printSumPath(List<List<Integer>> lists) {
        if(lists == null || lists.size() == 0) {
            System.out.println("error");
            return;
        }

        for(List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    private void testSuite() {
        Problems1 p = new Problems1();
        TreeNode test1 = p.constructFromString("10,5,12,4,7");
        List<List<Integer>> lists = p.getSumPath(test1, 22);
        p.printSumPath(p.getSumPath(test1, 22));

        TreeNode test2 = p.constructFromString("5, 4, 8, 11, 13, 4, 7, 2, 5, 1");
        p.printSumPath(p.getSumPath(test2, 22));

        TreeNode test3 = p.constructFromString("5, 4, 8, 11");
        p.printSumPath(p.getSumPath(test3, 22));

        TreeNode test4 = p.constructFromString("5, 4, 8, 11");
        p.printSumPath(p.getSumPath(test4, 20));

        TreeNode test5 = p.constructFromString("8");
        p.printSumPath(p.getSumPath(test5, 8));

        TreeNode test6 = p.constructFromString("");
        p.printSumPath(p.getSumPath(test6, 0));
    }

    public static void main(String[] args) {
       Problems1 p = new Problems1();
       p.testSuite();
    }
}
