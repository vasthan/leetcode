package com.adc._200_299._257_binary_tree_paths;

import java.util.ArrayList;
import java.util.List;

/**
 * 原题：https://leetcode-cn.com/problems/binary-tree-paths/
 * 求二叉树从根节点到叶子节点的所有路径
 *
 * 解法二：BottomUp的后序遍历，先求子树的所有路径，再把当前节点加到开头
 */
public class Solution2 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }
        if (root.left != null) {
            res.addAll(binaryTreePaths(root.left));
        }
        if (root.right != null) {
            res.addAll(binaryTreePaths(root.right));
        }
        for (int i = 0; i < res.size(); i++) {
            res.set(i, root.val + "->" + res.get(i));
        }
        return res;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
