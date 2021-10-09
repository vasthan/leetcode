package com.adc._0_99._62_unique_paths;

/**
 * 原题：https://leetcode-cn.com/problems/unique-paths/
 * m行 * n列的网格
 * 从左上角走到右下角，一共有多少种路径
 * 每次只能向右或向下走一步
 */
public class Solution {

    // 动态规划
    public int uniquePaths(int m, int n) {
        // 状态定义
        // dp[i][j]表示从(0,0)到(i,j)的不同路径数
        int[][] dp = new int[m][n];

        // 初始状态
        // 第一行dp[i][0]的值都为1，因为只能从左边走过来
        // 第一列dp[0][j]的值都为1，因为只能从上边走过来
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // 状态压缩
        // 只需要int[2][n]，O(2n)的空间保存状态即可
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(3, 7));
        System.out.println(s.uniquePaths(3, 2));
        System.out.println(s.uniquePaths(7, 3));
        System.out.println(s.uniquePaths(3, 3));
    }
}
