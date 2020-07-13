package com.adc._300_max._322_coin_change;

import java.util.HashMap;
import java.util.Map;

// 记忆化搜索，复杂度O(n)
public class Solution2 {

    private Map<Integer, Integer> memo;

    public int coinChange(int[] coins, int amount) {
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
}
