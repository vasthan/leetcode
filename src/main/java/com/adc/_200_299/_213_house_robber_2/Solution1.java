package com.adc._200_299._213_house_robber_2;

/**
 * 原题：https://leetcode-cn.com/problems/house-robber-ii/
 * 打劫问题2：房屋围绕成环形，也就是第一个房子和最后一个房子也相邻
 * 偷第一个房子的话，就不能偷最后一个房子
 */
public class Solution1 {
    public int rob(int[] nums) {
        // 入参检查
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, true), rob(nums, false));
    }

    private int rob(int[] nums, boolean robFirstHouse) {
        // 状态定义
        // dp[i]表示偷取[0, i]区间房子的最大价值
        int[] dp = new int[nums.length];

        // 初始状态
        if (robFirstHouse) {
            // 偷第一个房子
            dp[0]= dp[1] = nums[0];
        } else {
            // 不偷第一个房子
            dp[0] = 0;
            dp[1] = nums[1];
        }

        // 状态转移
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return robFirstHouse ? dp[nums.length - 2] : dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().rob(new int[]{2, 3, 2}));
        System.out.println(new Solution1().rob(new int[]{1, 2, 3, 1}));
    }
}
