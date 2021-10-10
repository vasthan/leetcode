package com.adc._300_max._337_house_robber_3;

import java.util.*;

/**
 * 原题：https://leetcode-cn.com/problems/house-robber-iii/
 * 房屋排列成二叉树结构，只能从根节点开始偷，不能偷直接相连的节点，求可偷取的最大价值
 *
 * 解法三：动态规划 + 利用二叉树层序遍历进行辅助
 */
public class Solution3 {

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<LevelNode> list = levelOrder(root);
        int n = list.size();

        // 状态定义
        // dp[0][i]表示，偷取以i为根的二叉树可获取的最大价值，且不偷取i
        // dp[1][i]表示，偷取以i为根的二叉树可获取的最大价值，且偷取i
        int[][] dp = new int[2][n];

        // 初始状态 + 状态转移
        int maxLevel = list.get(n - 1).level;
        System.out.println("maxLevel: " + maxLevel);
        for (int i = n - 1; i >= 0; i--) {
            LevelNode levelNode = list.get(i);
            if (levelNode.level == maxLevel) {
                // 最后一层的节点，可偷或不偷
                dp[0][i] = 0;
                dp[1][i] = levelNode.node.val;
            } else {
                // 状态转移
                // f(不偷i) = max(f(偷i->l), f(不偷i->l)) + max(f(偷i->r), f(不偷i->r))
                // f(偷i) = v(i) + f(不偷i->l) + f(不偷i->r)
                int leftChild = levelNode.leftIndex;
                int rightChild = levelNode.rightIndex;
                dp[0][i] = 0;
                dp[1][i] = levelNode.node.val;
                if (leftChild != -1) {
                    dp[0][i] += Math.max(dp[0][leftChild], dp[1][leftChild]);
                    dp[1][i] += dp[0][leftChild];
                }
                if (rightChild != -1) {
                    dp[0][i] += Math.max(dp[0][rightChild], dp[1][rightChild]);
                    dp[1][i] += dp[0][rightChild];
                }
            }
        }
        // 最终解max(偷0，不偷0)，0代表根节点
        return Math.max(dp[0][0], dp[1][0]);
    }

    /**
     * 层序遍历二叉树，把所有节点放入数组，并标记节点的层级、左右孩子在数组中的索引
     */
    private List<LevelNode> levelOrder(TreeNode root) {
        List<LevelNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                LevelNode levelNode = new LevelNode(node, level);
                if (node.left != null) {
                    queue.offer(node.left);
                    levelNode.leftIndex = queue.size() + list.size();
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    levelNode.rightIndex = queue.size() + list.size();
                }
                list.add(levelNode);
            }
        }
        return list;
    }

    static class LevelNode {
        TreeNode node;
        // 层级，从1开始
        int level;
        int leftIndex = -1;
        int rightIndex = -1;

        public LevelNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(4, new TreeNode(1), new TreeNode(3));
        TreeNode right = new TreeNode(5, null, new TreeNode(1));
        root.left = left;
        root.right = right;

        List<LevelNode> nodes = new Solution3().levelOrder(root);
        for (int i = 0; i < nodes.size(); i++) {
            LevelNode levelNode = nodes.get(i);
            System.out.println(i + ": val = " + levelNode.node.val + ", leftIndex: " + levelNode.leftIndex + ", rightIndex: " + levelNode.rightIndex + ", level = " + levelNode.level);
        }

        System.out.println(new Solution3().rob(root));
    }
}
