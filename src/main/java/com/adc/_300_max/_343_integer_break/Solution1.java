package com.adc._300_max._343_integer_break;

/**
 * 原题：https://leetcode-cn.com/problems/integer-break/
 * 解法一：暴力递归
 * 时间复杂度O(2^n)
 */
public class Solution1 {
    public int integerBreak(int n) {

        // 拆分
        // 1 * break(n - 1)
        // 2 * break(n - 2)
        // ...
        // (n - 1) * break(1)

        // 递归终止条件，n不可拆分
        if (n == 1 || n == 2) {
            return 1;
        }

        int res = -1;
        for (int i = 1; i < n; i++) {
            res = Math.max(Math.max(i * integerBreak(n - i), i * (n - i)), res);
        }
        return res;
    }
}
