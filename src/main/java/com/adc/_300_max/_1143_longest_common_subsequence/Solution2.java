package com.adc._300_max._1143_longest_common_subsequence;

import java.util.Arrays;

// 记忆化搜索
public class Solution2 {

    String s1, s2;
    int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        this.s1 = text1;
        this.s2 = text2;
        int m = s1.length(), n = s2.length();
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        return dp(m - 1, n - 1);
    }

    private int dp(int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (memo[i][j] == -1) {
            if (s1.charAt(i) == s2.charAt(j)) {
                memo[i][j] = dp(i - 1, j - 1) + 1;
            } else {
                memo[i][j] = Math.max(dp(i, j - 1), dp(i - 1, j));
            }
        }
        return memo[i][j];
    }
}
