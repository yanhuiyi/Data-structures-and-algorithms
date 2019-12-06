package com.datastructures;

public class BinarySearchTree {

    public TreeNode search(TreeNode root, int key) {
        if(root == null)
            return null;
        if(key == root.val)
            return root;

        if(key < root.val) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public TreeNode insert(TreeNode root, int key) {
        if(root == null)
          return new TreeNode(key);

        if(root.val > key) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }

        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;

        if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if(root.left == null || root.right == null) {
                root = root.left != null ? root.left : root.right;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null)
                    cur = cur.left;

                root.val = cur.val;
                root.right = deleteNode(root.right, cur.val);
            }
        }

        return root;
    }

    private void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public TreeNode deleteNode2(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val == key) {
            if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null)
                    cur = cur.left;

                swap(root.val, cur.val);
            }
        }

        root.left = deleteNode2(root.left, key);
        root.right = deleteNode2(root.right, key);
        return root;
    }

    public TreeNode delete(TreeNode root, int key) {
//        if(root == null) return null;
//
//        TreeNode cur = root;
//        TreeNode parent = cur;
//
//        while(cur.val != key) {
//            parent = cur;
//
//            if(key < cur.val) {
//                cur = cur.left;
//            } else {
//                cur = cur.right;
//            }
//        }
//
//        if(cur.right != null) {
//            while (cur.right != null) {
//                cur.val = cur.right.val;
//                cur = cur.right;
//            }
//            cur = null;
//        } else {
//            while (cur.left != null) {
//                cur.val = cur.left.val;
//                cur = cur.left;
//            }
//            cur = null;
//        }
//
//        return root;
        if(root == null) return null;

        TreeNode cur = root, pre = null;

        while(cur != null) {
            if(cur.val == key) break;

            pre = cur;

            if(cur.val > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        if(pre == null) delete(cur);

        if(pre.left != null && pre.left.val == key) {
            pre.left = delete(cur);
        } else {
            pre.right = delete(cur);
        }
        return root;
    }

    TreeNode delete(TreeNode node) {
        if(node == null) return null;

        if(node.right == null) return node.left;

        TreeNode cur = node.right;

        while (cur.left != null)
            cur = cur.left;

        cur.left = node.left;

        return node.right;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        TreeNode a = new TreeNode(3);
//        TreeNode b = new TreeNode(6);
//
//        root.left = a;
//        root.right = b;
//
//        a.left = new TreeNode(2);
//        a.right = new TreeNode(4);
//
//        b.right = new TreeNode(7);

//        System.out.printf("Insert key: 5\n");
//        TreeNode node = new BinarySearchTree().insert(root, 5);
//
//        System.out.println(node.val);
//
//        System.out.printf("\nSearch key: 5\n");
//
//        TreeNode target = new BinarySearchTree().search(root, 5);
//
//        System.out.println(target.val);

//        TreeNode target = new BinarySearchTree().delete(root, 3);
//        new BinarySearchTree().deleteNode(root, 3);

        TreeNode root = new TreeNode(15);
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(16);

        TreeNode c = new TreeNode(12);
        TreeNode d = new TreeNode(10);

        TreeNode e = new TreeNode(20);

        TreeNode f = new TreeNode(6);

        root.left = a;
        root.right = b;

        a.left = new TreeNode(3);
        a.right = c;

        c.left = d;
        c.right = new TreeNode(13);

        d.left = f;

        f.right = new TreeNode(7);

        b.right = e;
        e.left = new TreeNode(18);
        e.right = new TreeNode(23);

        new BinarySearchTree().deleteNode2(root, 5);
    }
}
