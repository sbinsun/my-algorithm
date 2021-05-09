package com.sbinjun.support.tree;


import java.util.LinkedList;
import java.util.Queue;

// 二叉树 遍历
public class BinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        root.left = left;
        root.right = right;

        TreeNode left_left = new TreeNode(3);
        TreeNode left_right = new TreeNode(6);
        left.left = left_left;
        left.right = left_right;

        TreeNode right_left = new TreeNode(14);
        TreeNode right_right = new TreeNode(20);
        right.left = right_left;
        right.right = right_right;

        TreeNode right_left_left = new TreeNode(13);
        right_left.left = right_left_left;

        BinaryTree binaryTree = new BinaryTree();
//        binaryTree.preTraveral(root);
//        binaryTree.midTraveral(root);
//        binaryTree.postTraveral(root);
        binaryTree.levelTraveral(root);
    }

    // 先序遍历
    private void preTraveral(TreeNode root){
        if (root == null) return;
        System.out.print(root.val + " ");

        preTraveral(root.left);
        preTraveral(root.right);
    }

    // 中序遍历
    private void midTraveral(TreeNode root) {
        if (root == null) return;
        midTraveral(root.left);
        System.out.print(root.val + " ");
        midTraveral(root.right);
    }

    // 后序遍历
    private void postTraveral(TreeNode root) {
        if (root == null) return;

        postTraveral(root.left);
        postTraveral(root.right);
        System.out.print(root.val + " ");
    }

    // 层序遍历
    private void levelTraveral(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null ) queue.offer(node.left);
            if (node.right != null )  queue.offer(node.right);
        }
    }
}

