package com.adc._0_99._5_longest_palindromic_substring;

public class Solution3 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        char[] c = s.toCharArray();
        int n = s.length();

        int begin = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (c[i] == c[j]) {
                    dp[i][j] = j - i < 3 ? true : dp[i+1][j-1];
                }
                if (dp[i][j] && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.longestPalindrome("babad"));
    }
}
