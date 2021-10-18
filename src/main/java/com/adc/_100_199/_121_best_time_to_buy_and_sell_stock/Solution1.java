package com.adc._100_199._121_best_time_to_buy_and_sell_stock;

/**
 * 原题：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 只能交易1次，最多只能持有1股
 *
 * 解法一：暴力解法-双重循环 + 剪枝
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int mp = 0;
        int min = Integer.MAX_VALUE;
        // 穷举所有买入卖出的组合，prices[i]表示买入，prices[j]表示卖出
        // 记录[0...i]的最小值min，如果prices[i] >= min，则进行剪枝
        // 因为minIndex <= i且prices[minIndex]小于prices[i]，那么肯定选择在minIndex买入收益更多
        for (int i = 0 ; i < n; i++) {
            if (prices[i] >= min) {
                continue;
            }
            min = prices[i];
            for (int j = i + 1; j < n; j++) {
                mp = Math.max(prices[j] - min, mp);
            }
        }
        return mp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().maxProfit(new int[]{2,1,2,1,0,1,2}));
    }
}
