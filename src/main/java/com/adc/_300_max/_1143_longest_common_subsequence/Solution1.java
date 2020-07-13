package com.adc._300_max._1143_longest_common_subsequence;

// 暴力搜索
class Solution1 {
    String s1, s2;

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        this.s1 = text1;
        this.s2 = text2;
        return dp(s1.length() - 1, s2.length() - 1);
    }

    // 求s1[0, i]和s2[0, j]的最长公共子序列长度
    private int dp(int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp(i - 1, j - 1) + 1;
        } else {
            return Math.max(dp(i - 1, j), dp(i, j - 1));
        }
    }
}
