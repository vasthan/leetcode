package com.adc._100_199._104_maximum_depth_of_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 原题：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 求二叉树的最大深度
 *
 * 解法二：BFS
 */
public class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return depth;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
