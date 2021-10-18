package com.adc._100_199._122_best_time_to_buy_and_sell_stock_2;

/**
 * 原题：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * 买卖股票的最佳时机，不限制交易次数，买之前必须卖掉，最多持有1股
 * 解法：动态规划
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        // 状态定义
        // dp[i][0]表示第i天不持股票的最大收益
        // dp[i][1]表示第i天持有股票的最大收益
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 状态转移
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(new Solution1().maxProfit(new int[]{1,2,3,4,5}));
    }
}
