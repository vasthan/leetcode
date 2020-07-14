package com.adc._200_299._221_maximal_square;

/*
221. 最大正方形
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4
 */
public class Solution1 {
    // 定义二维数组dp[m][n]，m和n分别为矩阵的行数和列数
    // dp[i][j]表示以(i, j)为右下角，且只包含1的最大正方形的边长
    public int maximalSquare(char[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int m, n;
        if ((m = matrix.length) == 0 || (n = matrix[0].length) == 0) {
            return 0;
        }
        // 每个位置默认值0
        int[][] dp = new int[m][n];
        // base case
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1'){
                    dp[i][j] = min3(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                }
            }
        }

        // 遍历dp数组，找最大正方形边长
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }

    private int min3(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    // 简洁写法
    public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        // 最大边长
        int maxSide = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = min3(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
