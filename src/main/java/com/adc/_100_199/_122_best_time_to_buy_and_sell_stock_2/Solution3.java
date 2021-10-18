package com.adc._100_199._122_best_time_to_buy_and_sell_stock_2;

/**
 * 原题：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * 买卖股票的最佳时机，不限制交易次数，买之前必须卖掉，最多持有1股
 * 解法三：贪心，遍历所有的价格上升段，累加收益，即为最大收益
 */
public class Solution3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int mp = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                mp += prices[i] - prices[i - 1];
            }
        }
        return mp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(new Solution3().maxProfit(new int[]{1,2,3,4,5}));
    }
}
