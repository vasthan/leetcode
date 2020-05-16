package com.adc._100_199._102_binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 二叉树层序遍历
class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("levelOrder1" + new Solution().levelOrder1(root));
        System.out.println("levelOrder2" + new Solution().levelOrder2(root));
        System.out.println("levelOrder3" + new Solution().levelOrder3(root));
    }

    public static class HNode {
        TreeNode node;
        int h;

        public HNode(TreeNode node, int h) {
            this.node = node;
            this.h = h;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 方法1 简单层序遍历
    public List<Integer> levelOrder1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                result.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }

    // 方法2 使用一个额外的节点类HNode，包含对应的节点以及高度
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Queue<HNode> queue = new LinkedList<>();
            queue.add(new HNode(root, 1));
            while (!queue.isEmpty()) {
                HNode hNode = queue.remove();
                TreeNode curNode = hNode.node;
                int curH = hNode.h;
                if (result.size() < curH) {
                    List<Integer> layer = new ArrayList<>();
                    result.add(layer);
                }
                result.get(curH - 1).add(curNode.val);
                if (curNode.left != null) {
                    queue.add(new HNode(curNode.left, curH + 1));
                }
                if (curNode.right != null) {
                    queue.add(new HNode(curNode.right, curH + 1));
                }
            }
        }
        return result;
    }

    // 方法3，不使用额外的数据结构
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> vals = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.remove();
                vals.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(vals);
        }
        return res;
    }
}
