package com.adc._300_max._300_longest_increasing_subsequence;

/**
 * 原题：https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 给定一个整数数组，找到其中最长严格递增子序列的长度
 *
 * 解法三：动态规划
 */
public class Solution3 {

    public int lengthOfLIS(int[] nums) {
        // 状态定义
        // dp[i]表示以nums[i]结尾的最长子序列的长度
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 初始状态，每个位置元素的最长上升子序列初始为自身
            dp[i] = 1;
        }

        // 状态转移
        // 依次遍历nums，dp[i] = max(dp[0...j] + 1, if nums[i] > nums[j], j < i)
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(s.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(s.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }

}
