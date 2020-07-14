package com.adc._200_299._236_lowest_common_ancestor_of_binary_tree;

/*
二叉树的最近公共祖先
 */
public class Solution1 {
    // 递归函数定义：在以root为根的树中寻找p和q，找到就返回
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归到底的情况
        // 1、root是空树，直接返回null
        // 2、root等于p或q，直接返回root
        if (root == null | root == p || root == q) {
            return root;
        }

        // 左子树中找p、q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 右子树中找p、q
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        // 左右子树中分别找到了p、q，表示root是最近公共祖先
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}