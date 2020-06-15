package com.adc._0_99._51_n_queens;

import java.util.*;

// Solution优化版本
// 击败100%
public class Solution2 {

    List<List<String>> res;
    boolean[] col;
    boolean[] dia1;
    boolean[] dia2;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if (n <= 0) return res;

        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        char[][] board = new char[n][n];
        for (char[] chars : board)
            Arrays.fill(chars, '.');

        putQueen(n, 0, board);
        return res;
    }

    private void putQueen(int n, int index, char[][] board) {
        if (n == index) {
            // 加入结果集
            res.add(generate(board));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                board[index][i] = 'Q';
                putQueen(n, index + 1, board);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                board[index][i] = '.';
            }
        }
    }

    private List<String> generate(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[4][4];
        for (char[] chars : board)
            Arrays.fill(chars, '.');
        board[1][2] = 'Q';
        System.out.println(new Solution2().generate(board));
    }
}
