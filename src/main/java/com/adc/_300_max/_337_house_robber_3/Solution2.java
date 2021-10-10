package com.adc._300_max._337_house_robber_3;

import java.util.HashMap;
import java.util.Map;

/**
 * 原题：https://leetcode-cn.com/problems/house-robber-iii/
 * 房屋排列成二叉树结构，只能从根节点开始偷，不能偷直接相连的节点，求可偷取的最大价值
 *
 * 解法二：递归 + 记忆化
 */
public class Solution2 {
    Map<TreeNode, Integer> includeMemo;
    Map<TreeNode, Integer> excludeMemo;

    public int rob(TreeNode root) {
        includeMemo = new HashMap<>();
        excludeMemo = new HashMap<>();
        return Math.max(rob(root, true), rob(root, false));
    }

    /**
     * 偷取以node为根的二叉树获取的最大价值
     * @param node      根节点
     * @param include   是否偷取node
     */
    private int rob(TreeNode node, boolean include) {
        if (node == null) {
            return 0;
        }

        if (include) {
            if (!includeMemo.containsKey(node)) {
                // 偷node，则不能偷node.left和node.right
                int val = node.val + rob(node.left, false) + rob(node.right, false);
                includeMemo.put(node, val);
            }
            return includeMemo.get(node);
        } else {
            if (!excludeMemo.containsKey(node)) {
                // 不偷node，则可偷node.left和node.right
                int lMax = Math.max(rob(node.left, true), rob(node.left, false));
                int rMax = Math.max(rob(node.right, true), rob(node.right, false));
                excludeMemo.put(node, lMax + rMax);
            }
            return excludeMemo.get(node);
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
