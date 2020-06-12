package com.adc._100_199._130_surrounded_regions;

import java.util.Arrays;

/*
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

示例:

X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：

X X X X
X X X X
X X X X
X O X X
解释:

被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/surrounded-regions
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

// 自己想的解法，提交AC超过98%，加个鸡腿哈哈哈😄
public class Solution {
    // 记录所有没有被'X'围绕的区域
    private boolean[][] visited;
    // m,n分别表示二维矩阵的行数、列数
    int m, n;
    // 表示上右下左4个方向
    int[][] directions = {{-1,0}, {0,1}, {1,0},{0,-1}};

    // 循环遍历边界每个元素，进行dfs，对于遍历到的O进行标记，完成后把没有被标记的区域填充为X
    public void solve(char[][] board) {
        if (board == null) return;
        if ((m = board.length) <= 2) return;
        if ((n = board[0].length) <= 2) return;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 边界上的元素
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (!visited[i][j] && board[i][j] == 'O') {
                        dfs(board, i , j);
                    }
                }
            }
        }
        // 填充
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (!visited[i][j]) board[i][j] = 'X';
    }

    private void dfs(char[][] board, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (inArea(newX, newY) && !visited[newX][newY] && board[newX][newY] == 'O') {
                dfs(board, newX, newY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        new Solution().solve(board);
        Arrays.stream(board).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }
}
