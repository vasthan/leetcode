package com.adc._0_99._52_n_queens_2;

/*
给定一个整数 n，返回 n 皇后不同的解决方案的数量。

不同于51题要求n皇后所有解，这道题只需要求出解的个数
 */

// 照搬51题解题方法，做一些简化
public class Solution {

    boolean[] col;
    boolean[] dia1;
    boolean[] dia2;
    int res = 0;

    public int totalNQueens(int n) {
        if (n <= 0) return 0;
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        dfs(n, 0);
        return res;
    }

    private void dfs(int n, int index) {
        if (index == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                col[i] = dia1[index + i] = dia2[index - i + n - 1] = true;
                dfs(n, index + 1);
                col[i] = dia1[index + i] = dia2[index - i + n - 1] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.totalNQueens(8));
    }
}
