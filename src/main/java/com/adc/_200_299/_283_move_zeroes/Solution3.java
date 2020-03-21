package com.adc._200_299._283_move_zeroes;

import java.util.Arrays;

// 双指针-元素交换法
// 时间复杂度：O(n)，空间复杂度：O(1)
public class Solution3 {

    // 区间[0, k)保存非零元素，k表示下一个非零元素要交换到的位置
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    swap(nums, k, i);
                }
                k++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution3().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
