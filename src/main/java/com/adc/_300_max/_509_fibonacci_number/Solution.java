package com.adc._300_max._509_fibonacci_number;

/**
 * fibonacci数列：1,1,2,3,5,8,13,21...
 */
class Solution {
    // 解法一：暴力递归，大量重复计算。时间复杂度O(2^n)，指数级
    public int fib(int N) {
        if (N < 1)
            return 0;
        if (N == 1 || N == 2)
            return 1;
        return fib(N - 1) + fib (N - 2);
    }

    // 解法二：递归+备忘录，解决重复计算问题。时间复杂度O(n)
    public int fib2(int N) {
        if (N < 1)
            return 0;
        // 为什么备忘录长度是N+1，因为fibonacci数列从1开始
        int[] memo = new int[N + 1];
        memo[1] = memo[2] = 1;
        return fib2(N, memo);
    }

    public int fib2(int n, int[] memo) {
        if (memo[n] != 0)
            return memo[n];
        memo[n] = fib2(n - 1, memo) + fib2(n - 2, memo);
        return memo[n];
    }

    // 解法三：动态规划，自底向上求解。也需要一个备忘录记录已经计算过的子问题，这里叫dp table
    // 算法性能和fib2差不多，复杂度是一个级别的
    public int fib3(int N) {
        if (N < 1)
            return 0;
        // 这里长度为N+2是偷懒了，当N=1时，能够保证dp[2]不越界
        int[] dp = new int[N + 2];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    // 解法三优化版本：当前状态只和之前的两个状态有关，不必保存所有状态
    public int fib3Plus(int N) {
        if (N < 1)
            return 0;
        int pre = 1, cur = 1;
        for (int i = 3; i <= N; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }
}
