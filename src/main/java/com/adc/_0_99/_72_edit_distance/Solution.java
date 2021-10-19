package com.adc._0_99._72_edit_distance;

/**
 * 原题：https://leetcode-cn.com/problems/edit-distance/
 *
 * 解法：动态规划
 */
public class Solution {

    /**
     * 把word1转换成word2需要的最少操作步骤，可以进行insert、delete、replace三种操作
     */
    public int minDistance(String word1, String word2) {
        // 1、状态定义：dp[i][j]表示word1前i个字符转换成word2前j个字符需要的最少操作步骤数
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // 2、初始状态
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // 3、状态转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println( new Solution().minDistance("horse", "ros"));
        System.out.println( new Solution().minDistance("intention", "execution"));
    }
}
