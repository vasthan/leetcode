package com.adc._200_299._279_perfect_squares;

/**
 * 递归 + 记忆化
 */
public class Solution2 {
    private int[] memo;
    public int numSquares(int n) {
        memo = new int[n + 1];
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo[n] == 0) {
            memo[n] = Integer.MAX_VALUE;
            for (int i = 1; i * i <= n; i++) {
                memo[n] = Math.min(memo[n], dfs(n - i * i) + 1);
            }
        }
        return memo[n];
    }
}
