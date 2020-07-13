package com.adc._300_max._1143_longest_common_subsequence;

// 动态规划
public class Solution3 {

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        int m = text1.length(), n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        // 初始化[0...m, 0]为0，第一列
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        // 初始化[0, 0...n]为0，第一行
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
