package com.adc._200_299._279_perfect_squares;

/**
 * 原题：https://leetcode-cn.com/problems/perfect-squares/
 * 解法一：暴力递归（超时）
 *
 * 类似于凑硬币的题：从[1, 4, 9, 16 ....]的面值中选择若干个硬币，加起来面值等于n，每个硬币可以重复使用
 *
 * 求最少需要使用多少个硬币
 */
public class Solution1 {
    public int numSquares(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            res = Math.min(res, numSquares(n - i * i) + 1);
        }
        return res;
    }
}
