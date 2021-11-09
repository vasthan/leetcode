package com.adc._0_99._98_validate_binary_search_tree;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 判断一棵树是不是二分搜索树
 * 解法一：递归
 */
public class Solution1 {
    // 左子树所有节点 < 根节点 < 右子树所有节点
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
