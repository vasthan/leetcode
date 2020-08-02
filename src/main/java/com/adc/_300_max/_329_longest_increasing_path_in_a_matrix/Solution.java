package com.adc._300_max._329_longest_increasing_path_in_a_matrix;

/*
329. 矩阵中的最长递增路径
给定一个整数矩阵，找出最长递增路径的长度。

对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。

示例 1:

输入: nums =
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
输出: 4
解释: 最长递增路径为 [1, 2, 6, 9]。
示例 2:

输入: nums =
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
输出: 4
解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。

递增：后面的数大于前面的数
 */
public class Solution {
    // 首先想到DFS
    // 两层for循环，对矩阵每个点作为起点进行DFS，寻找最长递增路径

    int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || (m = matrix.length) == 0) {
            return 0;
        }
        if (matrix[0] == null || (n = matrix[0].length) == 0) {
            return 0;
        }

        memo = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 剪枝优化：如果一个位置的数字比它周围的数字都要大，那么这个位置肯定不是最优的起点，可以跳过
                boolean skip = true;
                for (int[] dir : dirs) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (inArea(ii, jj) && matrix[i][j] < matrix[ii][jj]) {
                        skip = false;
                        break;
                    }
                }
                if (skip) continue;

                res = Math.max(res, dfs(i, j, matrix));
            }
        }
        return res;
    }

    // 上、右、下、左
    private int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    // memo[i][j]表示从(i,j)位置为起点的最长递增路径的长度
    private int[][] memo;

    private int dfs(int x, int y, int[][] matrix) {
        if (memo[x][y] != 0) {
            return memo[x][y];
        }
        memo[x][y] = 1;
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (inArea(newX, newY) && matrix[newX][newY] > matrix[x][y]) {
                memo[newX][newY] = dfs(newX, newY, matrix);
                memo[x][y] = Math.max(memo[x][y], memo[newX][newY] + 1);
            }
        }
        return memo[x][y];
    }

    private boolean inArea(int x, int y) {
        return x >=0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {3,4,5},
                {3,2,6},
                {2,2,1}
        };
        Solution s = new Solution();
        System.out.println(s.longestIncreasingPath(nums));
    }
}
