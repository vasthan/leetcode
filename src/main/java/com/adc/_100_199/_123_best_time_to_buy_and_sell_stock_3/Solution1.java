package com.adc._100_199._123_best_time_to_buy_and_sell_stock_3;

/**
 * 原题：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 最多交易（卖出）2次，卖出后才能继续买入
 * 解法一：动态规划（自己想的）
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        // 状态定义
        // 三维dp[i][j][k]：i表示第几天，j表示交易次数，k表示是否持有股票
        // dp[i][j][0]表示第i天，交易了j次，不持有股票的最大收益
        // dp[i][j][1]表示第i天，交易了j次，持有股票的最大收益
        int[][][] dp = new int[prices.length][3][2];

        // 初始状态
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j <= 2; j++) {
                if (j == 0) {
                    dp[i][0][0] = dp[i - 1][0][0];
                    dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i <= 2; i++) {
            res = Math.max(res, dp[prices.length - 1][i][0]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(new Solution1().maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(new Solution1().maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(new Solution1().maxProfit(new int[]{1}));
    }
}
