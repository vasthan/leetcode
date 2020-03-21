package com.adc._200_299._283_move_zeroes;

import java.util.Arrays;

// 双指针-元素移动法
// 时间复杂度：O(n)，空间复杂度：O(1)
public class Solution2 {

    public void moveZeroes(int[] nums) {

        // [0, k)区间保存非零元素，[k, nums.length)保存零
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution2().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
