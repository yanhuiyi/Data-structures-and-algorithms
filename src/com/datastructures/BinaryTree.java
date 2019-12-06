package com.datastructures;


import java.util.*;

public class BinaryTree {

    private void preorder(TreeNode root) {
        if( root != null) {
            System.out.printf("%s ", root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }

    private void inorder(TreeNode root) {
        if(root != null) {
            inorder(root.left);
            System.out.printf("%s ", root.val);
            inorder(root.right);
        }
    }

    private void postorder(TreeNode root) {
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.printf("%s ", root.val);
        }
    }

    private void iteratorPreorder(TreeNode root) {

        if(root == null) return;

        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();

            System.out.printf("%s ", node.val);

            if(node.right != null)
                stack.push(node.right);

            if(node.left != null)
                stack.push(node.left);
        }
    }

    private void iteratorPreorder2(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();

//        stack.add(root);

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                System.out.printf("%s ", root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
    }

    private void iteratorInorder(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            System.out.printf("%s ", root.val);
            root = root.right;
        }
    }

    private void iterativePostorder(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);

            if(node.left != null) stack1.push(node.left);
            if(node.right != null) stack1.push(node.right);
        }

        while(!stack2.isEmpty()) {
            TreeNode node = stack2.pop();
            System.out.printf("%s ", node.val);
        }
    }

    private void levelTravese(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.printf("%s ", node.val);
            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);
        }
    }

    private int height(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(7);

        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(6);

        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(5);

        TreeNode g = new TreeNode(8);
        TreeNode h = new TreeNode(9);

        root.left = a;
        root.right = b;

        a.left = c;
        a.right = d;

        c.right = e;
        e.right = f;

        b.left = g;
        b.right = h;

        System.out.printf("\nRecursive preorder traversal: \n");
        new BinaryTree().preorder(root);
        System.out.printf("\nIterative preorder traversal 1: \n");
        new BinaryTree().iteratorPreorder(root);
        System.out.printf("\nIterative preorder traversal 2: \n");
        new BinaryTree().iteratorPreorder2(root);
        System.out.printf("\nRecursive inorder traversal: \n");
        new BinaryTree().inorder(root);
        System.out.printf("\nIterative inorder traversal: \n");
        new BinaryTree().iteratorInorder(root);
        System.out.printf("\nRecursive postorder traversal: \n");
        new BinaryTree().postorder(root);
        System.out.printf("\nIterative postorder traversal: \n");
        new BinaryTree().iterativePostorder(root);
        System.out.printf("\nLevel traversal: \n");
        new BinaryTree().levelTravese(root);
        System.out.printf("\nHeight of tree: \n");
        System.out.println(new BinaryTree().height(root));
    }

}
