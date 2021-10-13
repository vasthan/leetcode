package com.adc._300_max._300_longest_increasing_subsequence;


/**
 * 原题：https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 给定一个整数数组，找到其中最长严格递增子序列的长度
 *
 * 解法二：递归 + 记忆化
 */
public class Solution2 {
    int[] memo;
    public int lengthOfLIS(int[] nums) {
        memo = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            // 对每个元素进行dfs，求出以nums[i]结尾的最长子序列的长度，再比较出最大值
            res = Math.max(res, dfs(nums, i));
        }
        return res;
    }

    /**
     * 以index结尾的最长子序列的长度
     */
    private int dfs(int[] nums, int index) {
        if (index == 0) {
            return 1;
        }
        if (memo[index] == 0) {
            int res = 1;
            for (int i = index - 1; i >= 0; i--) {
                if (nums[index] > nums[i]) {
                    res = Math.max(res, dfs(nums, i) + 1);
                }
            }
            memo[index] = res;
        }
        return memo[index];
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(s.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(s.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }

}
