package com.adc.other;

/*
给你一个容量为C的背包和N个物品

每个物品有体积c和价值v两个属性。其中第i个物品的体积为c[i]，价值为v[i]

现在让你用这个背包装物品，最多能装的价值是多少？
 */
// 0-1背包问题
public class Knapsack {
    // C - 背包容量
    // N - 物品数量
    // c[i] - 第i个物品占用的容量
    // v[i] - 第i个物品的价值
    public int knapsack(int C, int N, int[] c, int[] v) {
        if (C == 0 || N == 0) {
            return 0;
        }
        // 定义dp二维数组，dp[i][j]表示将前i个物品，放入容量为j的背包中，可容纳物品的最大价值
        // 当遍历完成后，dp[N][C]就是最后答案

        int[][] dp = new int[N + 1][C + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= C; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (c[i - 1] > j) {
                        // 第i个物品的体积大于背包总容量，放不进去
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // 考虑第i个物品：放进背包 or 不放
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i - 1]] + v[i - 1]);
                    }
                }
            }
        }
        return dp[N][C];
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] c = {1,2,3};
        int[] v = {3,4,5};
        System.out.println(ks.knapsack(5, 3, c, v));
    }
}
