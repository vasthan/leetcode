package com.adc._0_99._64_minimum_path_sum;

// 标准dp
public class Solution1 {
    public int minPathSum(int[][] grid) {

        // 状态定义, dp[i][j]表示从(0,0)到(i,j)的最小路径和
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // 初始状态, dp[0][0] = grid[0][0]
        dp[0][0] = grid[0][0];

        // 状态转移方程
        // dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        // i = 0时（第一行），dp[i][j] = dp[i][j - 1] + grid[i][j]
        // j = 0时（第一列），dp[i][j] = dp[i - 1][j] + grid[i][j]
        // dp[m - 1][n - 1]存放的就是最终的解
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = j == 0 ? dp[0][0] : dp[0][j - 1] + grid[0][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + grid[i][0];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];

        // 优化：状态压缩
        // 对于dp[i][j]的值，是从dp[i - 1][j]或者dp[i][j - 1]推导出来
        // 所以只需要保存i层和i - 1层的状态就够了，空间复杂度从O(m * n)下降为O(2n)

    }
}
