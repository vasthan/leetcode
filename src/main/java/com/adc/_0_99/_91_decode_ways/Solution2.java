package com.adc._0_99._91_decode_ways;

/**
 * 动态规划解法
 */
public class Solution2 {

    // dp[i]表示s[0...i]的解码方法数
    public int numDecodings(String s) {
        if (s == null || s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            // 当前字符单独解码
            if (s.charAt(i) != '0') {
                dp[i] += dp[i - 1];
            }
            // 当前字符和前一个字符一起解码，前一个字符不能为'0'
            if (s.charAt(i - 1) != '0' && (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') <= 26) {
                dp[i] += i == 1 ? 1 : dp[i - 2];
            }
            // 提前终止
            if (dp[i] == 0) {
                return 0;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().numDecodings("12"));
        System.out.println(new Solution2().numDecodings("226"));
        System.out.println(new Solution2().numDecodings("0"));
        System.out.println(new Solution2().numDecodings("06"));
    }
}
