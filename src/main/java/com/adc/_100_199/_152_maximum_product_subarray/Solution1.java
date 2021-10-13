package com.adc._100_199._152_maximum_product_subarray;

/**
 * 原题：https://leetcode-cn.com/problems/maximum-product-subarray/
 *
 * 最大乘积子数组（要求连续）
 * 解法一：动态规划
 */
public class Solution1 {
    public int maxProduct(int[] nums) {
        // 状态定义
        // max[i]表示，[0,i]范围内，且以nums[i]结尾的最大乘积子数组的乘积（正最大值）
        // min[i]表示，[0,i]范围内，且以nums[i]结尾的最小乘积子数组的乘积（负最大值）
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = min[0] = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                max[i] = Math.max(max[i - 1] * nums[i], nums[i]);
                min[i] = Math.min(min[i - 1] * nums[i], nums[i]);
            } else {
                max[i] = Math.max(min[i - 1] * nums[i], nums[i]);
                min[i] = Math.min(max[i - 1] * nums[i], nums[i]);
            }
        }

        int res = 0;
        for (int v : max) {
            res = Math.max(res, v);
        }
        return res;
    }
}
