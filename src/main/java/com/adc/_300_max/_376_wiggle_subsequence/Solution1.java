package com.adc._300_max._376_wiggle_subsequence;

/**
 * 原题：https://leetcode-cn.com/problems/wiggle-subsequence/
 *
 * 最长摆动子序列：子序列的元素交替升降
 *
 * 解法一：动态规划
 */
public class Solution1 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 状态定义
        // 一维数组不够用，需要二维
        // dp[i][0]表示以nums[i]结尾，且nums[i]在低位时的最长上升子序列的长度
        // dp[i][1]表示以nums[i]结尾，且nums[i]在高位时的最长上升子序列的长度
        int[][] dp = new int[nums.length][2];

        // 初始状态
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = 1;
            }
        }

        // 状态转移
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                } else if (nums[i] < nums[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                } else {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0]);
                    dp[i][1] = Math.max(dp[i][1], dp[j][1]);
                }
            }
        }

        // 状态压缩？dp[i][j]依赖dp[0...i-1]的状态，貌似没有压缩空间

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 2; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().wiggleMaxLength(new int[]{1,7,4,9,2,5}));
        System.out.println(new Solution1().wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
    }
}
