package com.adc._100_199._113_path_sum_2;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 路径总和2：找出所有从根节点到叶子节点，路径总和=targetSum的路径
 *
 * 解法一：自顶向下递归
 */
public class Solution1 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        if (root != null) {
            findPath(root, targetSum, new ArrayList<>(), paths);
        }
        return paths;
    }

    private void findPath(TreeNode node, int sum, List<Integer> path, List<List<Integer>> paths) {
        // 递归到底的情况
        if (node.left == null && node.right == null) {
            if (node.val == sum) {
                path.add(node.val);
                paths.add(path);
            }
            return;
        }
        path.add(node.val);
        if (node.left != null) {
            findPath(node.left, sum - node.val, new ArrayList<>(path), paths);
        }
        if (node.right != null) {
            findPath(node.right, sum - node.val, new ArrayList<>(path), paths);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
