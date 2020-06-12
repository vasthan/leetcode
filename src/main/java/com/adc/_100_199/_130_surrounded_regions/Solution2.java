package com.adc._100_199._130_surrounded_regions;

import java.util.Arrays;

// 优化版本，不使用visited二维数据标记与边界联通的'O'，而是直接将'O'替换为其他特殊符号，空间复杂度降低为O(1)
public class Solution2 {
    // m,n分别表示二维矩阵的行数、列数
    int m, n;
    // 表示上右下左4个方向
    int[][] directions = {{-1,0}, {0,1}, {1,0},{0,-1}};

    public void solve(char[][] board) {
        if (board == null) return;
        if ((m = board.length) <= 2) return;
        if ((n = board[0].length) <= 2) return;
        // 第一次标记
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                // 边界上的'O'
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O')
                    dfs(board, i , j);

        // 第二次标记
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        board[x][y] = '#';
        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (inArea(newX, newY) && board[newX][newY] == 'O') {
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
