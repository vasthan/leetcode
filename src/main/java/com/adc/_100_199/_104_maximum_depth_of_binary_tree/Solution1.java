package com.adc._100_199._104_maximum_depth_of_binary_tree;

/**
 * 原题：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 求二叉树的最大深度
 *
 * 解法一：DFS
 */
public class Solution1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
