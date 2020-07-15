package com.adc._300_max._494_target_sum;

/*
494. 目标和
给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
示例：
输入：nums: [1, 1, 1, 1, 1], S: 3
输出：5
解释：

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

一共有5种方法让最终目标和为3。
提示：

数组非空，且长度不会超过 20 。
初始的数组的和不会超过 1000 。
保证返回的最终结果能被 32 位整数存下。
 */

// 解法一：暴力回溯
// 本质是nums数组中的数字组合问题，求解和为S的组合数，每一次选择+nums[i]或-nums[i]
// 时间复杂度O(2^n)，n个数字，每个数字有+和-两种选择
public class Solution1 {
    int result;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        result = 0;
        dfs(nums, 0, S);
        return result;
    }

    private void dfs(int[] nums, int i, int target) {
        // 递归到底的情况
        if (i == nums.length) {
            if (target == 0) {
                result++;
            }
            return;
        }
        // 选择-nums[i]
        target += nums[i];
        // 下一层回溯
        dfs(nums, i + 1, target);
        // 撤销选择
        target -= nums[i];

        // +nums[i]
        target -= nums[i];
        dfs(nums, i + 1, target);
        target += nums[i];
    }
}
