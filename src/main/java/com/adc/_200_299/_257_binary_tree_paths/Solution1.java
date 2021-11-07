package com.adc._200_299._257_binary_tree_paths;

import java.util.ArrayList;
import java.util.List;

/**
 * 原题：https://leetcode-cn.com/problems/binary-tree-paths/
 * 求二叉树从根节点到叶子节点的所有路径
 *
 * 解法一：TopDown的前序遍历，按照从上往下的顺序进行递归把节点加到路径中，直到遇到叶子节点，就得到了一条路径
 */
public class Solution1 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, "", paths);
        return paths;
    }

    private void dfs(TreeNode node, String path, List<String> paths) {
        if (node != null) {
            path += node.val;
            if (node.left == null && node.right == null) {
                paths.add(path);
                return;
            }
            dfs(node.left, path + "->", paths);
            dfs(node.right, path + "->", paths);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
