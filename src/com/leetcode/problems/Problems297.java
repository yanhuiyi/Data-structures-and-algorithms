package com.leetcode.problems;

import java.util.*;

public class Problems297 {


    public void helper(TreeNode root, Queue<TreeNode> queue) {
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            helper(node.left, queue);
            helper(node.right, queue);
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) {
                sb.append("null ");
                continue;
            }
            sb.append(node == null ? "null " : node.val + " ");
//            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
//            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] values = data.split(" ");
        List<String> vals = new ArrayList(Arrays.asList(values));
        Queue<TreeNode> queue = new LinkedList<>();

        int index = 0;

        TreeNode root = new TreeNode(vals.get(index));

        queue.offer(root);

        for (index = 1; index < vals.size(); index++) {
            TreeNode parent = queue.poll();
            String cur = vals.get(index);

            if(!cur.equals("null")) {
                TreeNode node = new TreeNode(cur);
                parent.left = node;
                queue.offer(node);
            }

            cur = vals.get(++index);

            if(!cur.equals("null")) {
                TreeNode node = new TreeNode(cur);
                parent.right = node;
                queue.offer(node);
            }
        }

        return root;
    }


    public String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) return sb.toString();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sb.append(node != null ? node.val : "null").append(" ");

            if(node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString().trim();
    }

    public TreeNode deserialize2(String data) {
        if(data == null || data.length() == 0) return null;
        String[] s = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        for(int i = 1; i < s.length; i++) {
            TreeNode parent = queue.poll();

            if(!s[i].equals("null") && !s[i].equals("")) {
                TreeNode left = new TreeNode(Integer.parseInt(s[i]));
                parent.left = left;
                queue.offer(left);
            }

            i++;

            if(!s[i].equals("null") && !s[i].equals("")) {
                TreeNode right = new TreeNode(Integer.parseInt(s[i]));
                parent.right = right;
                queue.offer(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode leftChild = new TreeNode(2);
        TreeNode rightChild = new TreeNode(3);

        rightChild.left = new TreeNode(4);
        rightChild.right = new TreeNode(5);

        root.left = leftChild;
        root.right = rightChild;

//        String serializedTree = new Problems297().serialize(root);
//        System.out.println(serializedTree);
//
//        TreeNode deserializedTree = new Problems297().deserialize(serializedTree);
//        System.out.println(deserializedTree);

//        System.out.println(new Problems297().serialize(root));

        String serializedTree = new Problems297().serialize2(root);
        System.out.println(serializedTree);

        TreeNode deserializedTree = new Problems297().deserialize2(serializedTree);
        System.out.println(deserializedTree);
    }
}
