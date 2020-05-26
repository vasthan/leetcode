package com.adc._300_max._322_coin_change;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 解法一：自顶向下回溯，指数级复杂度
    public int coinChange1(int[] coins, int amount) {
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = coinChange1(coins, amount - coin);
            if (subProblem == -1)
                continue;
            res = Math.min(res, subProblem + 1);
        }
        return res;
    }

    // 解法二：记忆化搜索，复杂度O(n)
    private Map<Integer, Integer> memo;

    public int coinChange2(int[] coins, int amount) {
        memo = new HashMap<>();
        return dfs(coins, amount);
    }

    private int dfs(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (memo.containsKey(amount)) return memo.get(amount);

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dfs(coins, amount - coin);
            if (subProblem != -1) {
                res = Math.min(res, subProblem + 1);
            }
        }
        memo.put(amount, res == Integer.MAX_VALUE ? -1 : res);
        return memo.get(amount);
    }

    // 解法三：动态规划，自底向上
    public int coinChange3(int[] coins, int amount) {
        if (amount <= 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
