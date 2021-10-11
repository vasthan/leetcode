package com.adc._300_max._322_coin_change;

/**
 * 原题：https://leetcode-cn.com/problems/coin-change/
 * 凑零钱：提供一些面值的硬币，求能够凑出amount金额的最少硬币数量，每种硬币的数量是无限的
 *
 * 解法一：暴力递归回溯（超时），搜索每一种能凑出amount金额的方案，再比较每种方案所需的硬币数量
 */
public class Solution1 {

    int maxAmount;

    public int coinChange(int[] coins, int amount) {
        maxAmount = amount + 1;
        int res = search(coins, amount);
        return res == maxAmount ? -1 : res;
    }

    public int search(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int res = maxAmount;
        for (int i = 0; i < coins.length && amount >= coins[i]; i++) {
            res = Math.min(res, search(coins, amount - coins[i]) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new Solution1().coinChange(new int[]{2}, 3));
        System.out.println(new Solution1().coinChange(new int[]{1}, 0));
        System.out.println(new Solution1().coinChange(new int[]{1}, 1));
        System.out.println(new Solution1().coinChange(new int[]{1}, 2));
    }

}
