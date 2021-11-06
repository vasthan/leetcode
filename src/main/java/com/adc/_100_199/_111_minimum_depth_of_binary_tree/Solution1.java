package com.adc._100_199._111_minimum_depth_of_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 原题：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 求二叉树的最小深度
 *
 * 解法：BFS，类似于最短路径，使用BFS可以很容易解决
 */
public class Solution1 {

    // 使用BFS层序遍历，遇到左右孩子节点都为null的第一个节点时停止，此时的深度就是最小深度
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left == null && node.right == null) {
                    return depth;
                }
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
