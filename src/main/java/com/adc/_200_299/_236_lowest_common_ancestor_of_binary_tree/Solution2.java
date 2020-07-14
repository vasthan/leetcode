package com.adc._200_299._236_lowest_common_ancestor_of_binary_tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
自底向上迭代
 */
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 使用map存储所有元素的父节点
        Map<Integer, TreeNode> map = new HashMap<>();
        dfs(root, map);

        Set<Integer> set = new HashSet<>();
        while (p != null) {
            set.add(p.val);
            p = map.get(p.val);
        }

        while (q != null) {
            if (set.contains(q.val)) {
                return q;
            }
            q = map.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode node, Map<Integer, TreeNode> map) {
        if (node.left != null) {
            map.put(node.left.val, node);
            dfs(node.left, map);
        }
        if (node.right != null) {
            map.put(node.right.val, node);
            dfs(node.right, map);
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

