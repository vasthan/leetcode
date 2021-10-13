package com.adc._300_max._376_wiggle_subsequence;

/**
 * 原题：https://leetcode-cn.com/problems/wiggle-subsequence/
 *
 * 最长摆动子序列：子序列的元素交替升降
 *
 * 解法三：贪心
 */
public class Solution3 {
    public int wiggleMaxLength(int[] nums) {
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().wiggleMaxLength(new int[]{1,7,4,9,2,5}));
        System.out.println(new Solution3().wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
    }
}
