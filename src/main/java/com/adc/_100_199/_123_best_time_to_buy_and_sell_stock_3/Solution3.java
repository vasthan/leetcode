package com.adc._100_199._123_best_time_to_buy_and_sell_stock_3;

/**
 * 原题：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 最多交易（卖出）2次，卖出后才能继续买入
 * 解法三：动态规划 官方极简代码
 */
public class Solution3 {
    public int maxProfit(int[] prices) {
        // 状态定义
        // buy1第一次买入
        // sell1第一次卖出
        // buy2第二次买入
        // sell2第二次卖出

        // 初始状态，第0天，这些状态的初始值
        int buy1 = -prices[0], buy2 = -prices[0];
        int sell1 = 0, sell2 = 0;
        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }
        return Math.max(sell1, sell2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(new Solution3().maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(new Solution3().maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(new Solution3().maxProfit(new int[]{1}));
    }
}
