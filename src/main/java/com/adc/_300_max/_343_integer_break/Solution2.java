package com.adc._300_max._343_integer_break;

/**
 * 原题：https://leetcode-cn.com/problems/integer-break/
 * 解法二：递归 + 记忆化
 * 时间复杂度：O(n^2)，空间复杂度：O(n)
 */
public class Solution2 {

    private int[] memo;

    public int integerBreak(int n) {
        memo = new int[n + 1];
        return breakInteger(n);
    }

    private int breakInteger(int n) {
        // 递归终止条件，n不可拆分
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo[n] == 0) {
            for (int i = 1; i < n; i++) {
                memo[n] = Math.max(Math.max(i * breakInteger(n - i), i * (n - i)), memo[n]);
            }
        }
        return memo[n];
    }
}
