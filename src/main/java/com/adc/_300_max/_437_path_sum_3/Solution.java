package com.adc._300_max._437_path_sum_3;

/**
 * https://leetcode-cn.com/problems/path-sum-iii/
 *
 * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = findPath(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    /**
     * 在以node为根的二叉树中，包含node节点，和为sum的路径数量
     */
    private int findPath(TreeNode node, int sum) {
        int res = 0;
        if (node == null) {
            return res;
        }
        if (node.val == sum) {
            res += 1;
        }
        res += findPath(node.left, sum - node.val);
        res += findPath(node.right, sum - node.val);
        return res;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

}
