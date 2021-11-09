package com.adc._0_99._98_validate_binary_search_tree;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 判断一棵树是不是二分搜索树
 * 解法二：中序遍历
 */
public class Solution2 {
    // 中序遍历
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean l = isValidBST(root.left);
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        boolean r = isValidBST(root.right);
        return l && r;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
