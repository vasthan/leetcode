package com.adc._200_299._297_serialize_and_deserialize_binary_tree;

import java.util.LinkedList;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /*
        如下二叉树：
                 0
               /  \
              1    2
                  / \
                 3   4

        前序遍历结果：0 1 null null 2 3 null null 4 null null
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);

        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);

        right.left = new TreeNode(3);
        right.right = new TreeNode(4);

        root.left = left;
        root.right = right;

        Solution solution = new Solution();
        String s = solution.serialize(root);
        System.out.println(s);

        TreeNode root2 = solution.deserialize(s);
        System.out.println(isSameTree(root, root2));
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        ser(root, sb);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        for (String s : data.split(",")) {
            list.addLast(s);
        }
        return deser(list);
    }

    private void ser(TreeNode root, StringBuilder sb) {
        if (root == null) {
            // #表示空节点
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        ser(root.left, sb);
        ser(root.right, sb);
    }

    private TreeNode deser(LinkedList<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        String e = list.removeFirst();
        if ("#".equalsIgnoreCase(e)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(e));
        root.left = deser(list);
        root.right = deser(list);
        return root;
    }
}
