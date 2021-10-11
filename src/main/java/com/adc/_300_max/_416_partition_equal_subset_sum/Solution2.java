package com.adc._300_max._416_partition_equal_subset_sum;

import java.util.Arrays;

/**
 * 原题：https://leetcode-cn.com/problems/partition-equal-subset-sum/
 *
 * 给定一个数组，是否可以分割成两部分，两部分的和相等
 * 分析：等价于从数组中选择一部分数字，和等于sum / 2（sum必须是偶数）
 *
 * 解法二：DP
 */
public class Solution2 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }

        // 状态定义
        // dp[i][c]表示使用[0...i]这些物品，是否可以完全填充容量c的背包
        int half = sum / 2;
        boolean[][] dp = new boolean[nums.length][half + 1];
        for (int i = 0; i <= half; i++) {
            dp[0][i] = nums[0] == i;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= half; j++) {
                dp[i][j] = dp[i - 1][j] || (j >= nums[i] && dp[i - 1][j - nums[i]]);
            }
        }
        return dp[nums.length - 1][half];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(new Solution2().canPartition(new int[]{1, 2, 3, 5}));
    }
}
