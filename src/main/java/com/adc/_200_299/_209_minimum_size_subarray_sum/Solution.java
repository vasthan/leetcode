package com.adc._200_299._209_minimum_size_subarray_sum;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例:
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */

// 滑动窗口。时间复杂度O(n)，空间复杂度O(1)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1;
        int sum = 0;
        int minSize = nums.length + 1;

        while (l < nums.length) {
            if (sum < s && r + 1 < nums.length) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }
            if (sum >= s) {
                minSize = Math.min(minSize, r - l + 1);
            }
        }
        if (minSize == nums.length + 1) {
            minSize = 0;
        }
        return minSize;
    }
}
