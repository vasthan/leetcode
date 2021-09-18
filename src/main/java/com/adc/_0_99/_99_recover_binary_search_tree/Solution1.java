package com.adc._0_99._99_recover_binary_search_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 */
class Solution1 {

    List<TreeNode> res = new ArrayList<>();

    // 一次中序遍历，放到一个List容器中，然后找出错误的位置
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int x = -1, y = -1;
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i).val > res.get(i + 1).val) {
                if (x == -1) {
                    x = i;
                }
                y = i + 1;
            }
        }

        // 交换节点值
        int tmp = res.get(x).val;
        res.get(x).val = res.get(y).val;
        res.get(y).val = tmp;
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            res.add(root);
            inOrder(root.right);
        }
    }

}
