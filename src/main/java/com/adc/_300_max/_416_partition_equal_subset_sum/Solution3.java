package com.adc._300_max._416_partition_equal_subset_sum;

import java.util.Arrays;

/**
 * 原题：https://leetcode-cn.com/problems/partition-equal-subset-sum/
 *
 * 给定一个数组，是否可以分割成两部分，两部分的和相等
 * 分析：等价于从数组中选择一部分数字，和等于sum / 2（sum必须是偶数）
 *
 * 解法三：DP + 状态压缩 + 从后向前DP
 */
public class Solution3 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }

        // 状态定义
        // dp[c]表示能够填充满容量为c的背包
        int c = sum / 2;
        boolean[] dp = new boolean[c + 1];
        // 初始状态
        for (int i = 0; i <= c; i++) {
            dp[i] = nums[0] == i;
        }
        // 状态转移，从后向前，原地转移
        for (int i = 1; i < nums.length; i++) {
            for (int j = c; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[c];
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(new Solution3().canPartition(new int[]{1, 2, 3, 5}));
    }
}
