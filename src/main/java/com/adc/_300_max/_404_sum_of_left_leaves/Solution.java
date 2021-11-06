package com.adc._300_max._404_sum_of_left_leaves;

/**
 * 原题：https://leetcode-cn.com/problems/sum-of-left-leaves/
 * 求二叉树所有左叶子之和
 *
 * 解法：DFS
 */
public class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        if (root.left != null) {
            sum += isLeaf(root.left) ? root.left.val : sumOfLeftLeaves(root.left);
        }
        if (root.right != null && !isLeaf(root.right)) {
            sum += sumOfLeftLeaves(root.right);
        }
        return sum;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
