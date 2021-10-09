package com.adc._100_199._198_house_robber;

/**
 * 原题：https://leetcode-cn.com/problems/house-robber/
 * 打劫问题：不能偷相邻的房屋，能偷取的最大价值
 */
public class Solution1 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        // 状态定义
        // dp[i]表示偷取[i, n)房屋的最大价值
        // 最终的解存放在dp[0]中，所以我们从后往前递推
        int[] dp = new int[n];

        // 初始状态
        // 只偷最后一个房子
        dp[n - 1] = nums[n - 1];
        // 只偷最后两个房子，所以取两者中的较大值
        dp[n - 2] = Math.max(nums[n - 1], nums[n - 2]);

        // 状态转移
        for (int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        // 状态能否压缩，见Solution2
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new Solution1().rob(new int[]{2, 7, 9, 3, 1}));
    }
}
