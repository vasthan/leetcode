package com.adc._200_299._279_perfect_squares;

import java.util.Arrays;

/**
 * 动态规划解法
 */
public class Solution3 {
    public int numSquares(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must greater than 0");
        }
        // 状态定义：dp[i]表示凑成和为n所需要的最少完全平方数的数量
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 初始状态
        dp[0] = 0;
        dp[1] = 1;

        // 状态转移
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
