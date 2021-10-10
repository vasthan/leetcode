package com.adc._300_max._337_house_robber_3;

/**
 * 原题：https://leetcode-cn.com/problems/house-robber-iii/
 * 房屋排列成二叉树结构，只能从根节点开始偷，不能偷直接相连的节点，求可偷取的最大价值
 *
 * 深度优先后序遍历 + DP
 */
public class Solution4 {

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * 给定以node为根的二叉树，返回偷和不偷该节点分别可获取的最大价值
     * @return int[0]表示不偷node节点可获取的最大价值，int[1]表示偷node节点可获取的最大价值
     */
    private int[] dfs(TreeNode node) {
        int[] res = new int[2];
        if (node == null) {
            return res;
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + node.val;
        return res;
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
