package com.adc._300_max._376_wiggle_subsequence;

/**
 * 原题：https://leetcode-cn.com/problems/wiggle-subsequence/
 *
 * 最长摆动子序列：子序列的元素交替升降
 *
 * 解法二：动态规划（另一种状态定义方式）
 */
public class Solution2 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 状态定义
        // up[i]表示前i个元素，以[0,i]中某个元素结尾，且该元素为峰（上升）时，最长摆动子序列的长度
        // down[i]表示前i个元素，以[0,i]中某个元素结尾，且该元素为谷（下降）时，最长摆动子序列的长度
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];

        // 初始状态
        up[0] = down[0] = 1;

        // 状态转移
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]){
                up[i] = up[i - 1];
                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().wiggleMaxLength(new int[]{1,7,4,9,2,5}));
        System.out.println(new Solution2().wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
    }
}
