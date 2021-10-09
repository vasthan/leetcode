package com.adc._200_299._213_house_robber_2;

/**
 * 更优雅的实现：robRange
 * 参考leetcode官方题解：https://leetcode-cn.com/problems/house-robber-ii/solution/da-jia-jie-she-ii-by-leetcode-solution-bwja/
 */
public class Solution2 {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
