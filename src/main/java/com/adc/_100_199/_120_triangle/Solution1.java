package com.adc._100_199._120_triangle;

import java.util.List;

/*
120. 三角形最小路径和
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */

/*
base case:
f[0][0] = c[0][0]，c[i][j]表示三角形(i, j)位置的元素值

状态转移方程：
f[i][0] = f[i - 1][0] + c[i][0]                         j = 0
f[i][i] = f[i - 1][j - 1] + c[i][i]                     j = i
f[i][j] = min(f[i - 1][j - 1], f[i - 1][j]) + c[i][j]   j > 0 & j < i
 */

// 时间复杂度O(n^2)，n是三角形的行数
// 空间复杂度O(n^2)，因为使用了额外n*n的二维数组
public class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        // 初始化n * n的二维数组保存状态，f[i][j]表示从三角形顶部到(i, j)位置的最小路径和
        int[][] f = new int[n][n];
        // f[0][0]是base case，即在三角形顶部时，最小路径和就等于该位置的元素
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }

        // 最终答案就是dp数组最下层中的最小值，也就是f[n - 1][0]到f[n - 1][n - 1]中的最小值
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, f[n - 1][i]);
        }
        return res;
    }
}
