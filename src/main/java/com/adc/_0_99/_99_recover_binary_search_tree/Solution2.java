package com.adc._0_99._99_recover_binary_search_tree;

/**
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 */
class Solution2 {

    // x在前，y在后
    TreeNode x, y;

    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    // 一次中序遍历，不使用额外容器
    public void recoverTree(TreeNode root) {
        inOrder(root);
        swap(x, y);
    }

    private void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            if (prev.val > root.val) {
                y = root;
                if (x == null) {
                    x = prev;
                }
            }
            prev = root;
            inOrder(root.right);
        }
    }
}
