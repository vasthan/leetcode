package com.adc._100_199._111_minimum_depth_of_binary_tree;

/**
 * 原题：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 求二叉树的最小深度（从根节点到最近叶子节点的路径上的节点数量）
 *
 * 解法：DFS
 * TODO 进一步优化：剪枝
 */
public class Solution2 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        return minDepth + 1;
    }

    // 更简洁的写法
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null) {
            return minDepth2(root.right) + 1;
        } else if (root.right == null) {
            return minDepth2(root.left) + 1;
        } else {
            return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
