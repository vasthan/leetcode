package com.adc._300_max._322_coin_change;

import java.util.Arrays;

/**
 * 原题：https://leetcode-cn.com/problems/coin-change/
 * 凑零钱：提供一些面值的硬币，求能够凑出amount金额的最少硬币数量，每种硬币的数量是无限的
 *
 * 解法二：递归 + 记忆化
 */
public class Solution2 {
    // 解法二：递归 + 记忆化
    // memo[i]表示凑齐金额i所需要的最少硬币数量
    private int[] memo;
    private int maxAmount;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        maxAmount = amount + 1;
        Arrays.fill(memo, -1);
        int res = search(coins, amount);
        return res == maxAmount ? -1 : res;
    }

    private int search(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] == -1) {
            int res = maxAmount;
            for (int i = 0; i < coins.length && amount >= coins[i]; i++) {
                res = Math.min(res, search(coins, amount - coins[i]) + 1);
            }
            memo[amount] = res;
        }
        return memo[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new Solution2().coinChange(new int[]{2}, 3));
        System.out.println(new Solution2().coinChange(new int[]{1}, 0));
        System.out.println(new Solution2().coinChange(new int[]{1}, 1));
        System.out.println(new Solution2().coinChange(new int[]{1}, 2));
    }

}
