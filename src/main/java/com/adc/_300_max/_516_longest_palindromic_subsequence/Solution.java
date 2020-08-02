package com.adc._300_max._516_longest_palindromic_subsequence;

/*
516. 最长回文子序列
给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。

示例 1:
输入:"bbbab"
输出:4
一个可能的最长回文子序列为 "bbbb"。

示例 2:
输入:"cbbd"
输出:2
一个可能的最长回文子序列为 "bb"。

提示：

1 <= s.length <= 1000
s 只包含小写英文字母
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int n = s.length();
        char[] c = s.toCharArray();
        int[][] dp = new int[n][n]; // int数组默认值为0，不用显示初始化了
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = c[i] == c[j] ? dp[i+1][j-1] + 2 : Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
