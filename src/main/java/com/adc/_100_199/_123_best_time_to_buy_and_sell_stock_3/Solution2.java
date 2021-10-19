package com.adc._100_199._123_best_time_to_buy_and_sell_stock_3;

/**
 * 原题：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 最多交易（卖出）2次，卖出后才能继续买入
 * 解法二：动态规划（官方题解，工整DP）
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        // 天数、交易次数、是否持有股票
        // 状态定义，对于第i天，有以下5种状态
        // 1 没有买也没有卖，交易次数0，不持有股票
        // 2 买入一次，交易次数1，持有股票
        // 3 买入一次卖出一次，交易次数1，不持有股票
        // 4 再次买入，交易次数2，持有股票
        // 5 再次卖出，交易次数2，不持有股票
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
        // 初始状态
        // 对于第0天，可以有前3个状态
        dp[0][0][0] = 0; // 不买不卖
        dp[0][1][1] = -prices[0];// 买入
        dp[0][1][0] = 0; // 买入然后卖出
        dp[0][2][1] = -prices[0];// 再次买入
        dp[0][2][0] = 0; // 再次卖出
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = dp[i - 1][0][0];
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
        }
        int res = 0;
        for (int i = 0; i <= 2; i++) {
            if (dp[n - 1][i][0] > res) {
                res = dp[n - 1][i][0];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(new Solution2().maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(new Solution2().maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(new Solution2().maxProfit(new int[]{1}));
    }
}
