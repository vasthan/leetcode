package com.adc._0_99._96_unique_binary_search_trees;

/*
96. 不同的二叉搜索树
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


假设以1 .. n为节点组成的二叉搜索树有g(n)种，f(i)表示以i为根的二叉搜索树的个数
则有：g(n) = f(1) + f(2) + ... + f(n)

当i为根节点时，左子树节点个数为i-1个，右子树节点个数为n-i个（二叉搜索树的有序性质）
则有：f(i) = g(i-1) * g(n-i)

结合以上两个公式，可以得到：
g(n) = g(0) * g(n-1) + g(1) * g(n-2) + ... + g(n-1) * g(0)
 */
public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
