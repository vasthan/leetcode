package com.adc._100_199._122_best_time_to_buy_and_sell_stock_2;

/**
 * 原题：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * 买卖股票的最佳时机，不限制交易次数，买之前必须卖掉，最多持有1股
 * 解法二：动态规划 + 状态压缩
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        // 状态定义
        // mp0表示第i天不持股票的最大收益
        // mp1表示第i天持有股票的最大收益
        int mp0 = 0, mp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 状态转移
            int newMp0 = Math.max(mp0, mp1 + prices[i]);
            int newMp1 = Math.max(mp1, mp0 - prices[i]);
            mp0 = newMp0;
            mp1 = newMp1;
        }
        return mp0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(new Solution2().maxProfit(new int[]{1,2,3,4,5}));
    }
}
