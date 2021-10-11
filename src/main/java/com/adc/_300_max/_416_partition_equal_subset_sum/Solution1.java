package com.adc._300_max._416_partition_equal_subset_sum;

import java.util.Arrays;

/**
 * 原题：https://leetcode-cn.com/problems/partition-equal-subset-sum/
 *
 * 给定一个数组，是否可以分割成两部分，两部分的和相等
 * 分析：等价于从数组中选择一部分数字，和等于sum / 2（sum必须是偶数）
 *
 * 解法一：递归 + 记忆化
 */
public class Solution1 {
    // memo[i][c]表示使用索引为[0...i]的这些元素，是否可以完全填充容量为c的背包
    // 0表示未计算，1表示可以填充，-1表示不可以填充
    int[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        memo = new int[nums.length][sum / 2 + 1];
        return canPartition(nums, nums.length - 1, sum / 2);
    }

    // 递归函数定义：能否从[0, index]区间中选出一部分数字，填充容量为sum的背包
    private boolean canPartition(int[] nums, int index, int sum) {
        if (sum == 0) {
            return true;
        }
        if (index < 0 || sum < 0) {
            return false;
        }
        if (memo[index][sum] == 0) {
            memo[index][sum] = canPartition(nums, index - 1, sum)
                    || canPartition(nums, index - 1, sum - nums[index]) ? 1 : -1;
        }
        return memo[index][sum] == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(new Solution1().canPartition(new int[]{1, 2, 3, 5}));
    }
}
