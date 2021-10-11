package com.adc._300_max._322_coin_change;

/**
 * 原题：https://leetcode-cn.com/problems/coin-change/
 * 凑零钱：提供一些面值的硬币，求能够凑出amount金额的最少硬币数量，每种硬币的数量是无限的
 *
 * 解法三：动态规划
 */
public class Solution3 {

    public int coinChange(int[] coins, int amount) {
        // 状态定义
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        // 初始状态
        dp[0] = 0;

        // 状态转移
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        System.out.println(new Solution3().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new Solution3().coinChange(new int[]{2}, 3));
        System.out.println(new Solution3().coinChange(new int[]{1}, 0));
        System.out.println(new Solution3().coinChange(new int[]{1}, 1));
        System.out.println(new Solution3().coinChange(new int[]{1}, 2));
    }

}
