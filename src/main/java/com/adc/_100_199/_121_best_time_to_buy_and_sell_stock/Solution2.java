package com.adc._100_199._121_best_time_to_buy_and_sell_stock;

/**
 * 原题：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 只能交易1次，最多只能持有1股
 *
 * 解法二：一次遍历
 * 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格 - 前i-1天的最低价格}
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int mp = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                mp = Math.max(mp, price - minPrice);
            }
        }
        return mp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().maxProfit(new int[]{2,1,2,1,0,1,2}));
    }
}
