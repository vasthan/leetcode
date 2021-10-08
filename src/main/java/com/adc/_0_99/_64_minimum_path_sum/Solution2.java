package com.adc._0_99._64_minimum_path_sum;

// 经过状态压缩优化后的dp
public class Solution2 {
    public int minPathSum(int[][] grid) {
        // 直接在grid上原地dp，因为在求解出dp[i][j]的值后，grid[i][j]再也不会被使用到了
        // 所以直接把dp[i][j]保存在grid[i][j]中

        // 状态定义, grid[i][j]表示从(0,0)到(i,j)的最小路径和
        int m = grid.length;
        int n = grid[0].length;

        // 状态转移方程
        // grid[i][j] = min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j]
        // i = 0时（第一行），grid[i][j] = grid[i][j - 1] + grid[i][j]
        // j = 0时（第一列），grid[i][j] = grid[i - 1][j] + grid[i][j]
        // grid[m - 1][n - 1]存放的就是最终的解
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    grid[i][j] = j == 0 ? grid[0][0] : grid[0][j - 1] + grid[0][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][0] + grid[i][0];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
