package com.adc._300_max._343_integer_break;
/**
 * 原题：https://leetcode-cn.com/problems/integer-break/
 * 解法三：动态规划
 * 时间复杂度：O(n^2)，空间复杂度：O(n)
 */
public class Solution3 {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(j * dp[i - j], j * (i - j)), dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().integerBreak(8));
    }
}
