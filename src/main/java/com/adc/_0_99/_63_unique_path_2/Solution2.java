package com.adc._0_99._63_unique_path_2;

/**
 * 原题：https://leetcode-cn.com/problems/unique-paths-ii/
 * m行 * n列的网格，网格中有障碍物，0表示通路，1表示障碍物
 * 从左上角走到右下角，一共有多少种路径
 * 每次只能向右或向下走一步
 *
 * 优化：状态压缩，直接在grid上记录状态
 */
public class Solution2 {
    // 动态规划
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    obstacleGrid[i][j] = 1;
                } else if (i == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                } else if (j == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
}
