package com.adc._100_199._198_house_robber;

/**
 * 原题：https://leetcode-cn.com/problems/house-robber/
 * 打劫问题：不能偷相邻的房屋，能偷取的最大价值
 *
 * 优化：状态压缩，直接在nums上进行DP
 */
public class Solution2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        nums[n - 2] = Math.max(nums[n - 1], nums[n - 2]);
        for (int i = n - 3; i >= 0; i--) {
            nums[i] = Math.max(nums[i] + nums[i + 2], nums[i + 1]);
        }
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new Solution2().rob(new int[]{2, 7, 9, 3, 1}));
    }
}
