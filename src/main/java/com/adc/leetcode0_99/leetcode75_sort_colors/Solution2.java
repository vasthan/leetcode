package com.adc.leetcode0_99.leetcode75_sort_colors;

import java.util.Arrays;

/**
 * 使用三路快排的思想优化，只需要一趟遍历，非常优秀！
 * 时间复杂度O(n)，空间复杂度O(1)
 */
public class Solution2 {

    public void sortColors(int[] nums) {
        int zero = -1;          // [0, zero]区间保存0
        int two = nums.length;  // [two, nums.length - 1]区间保存2

        // [zero + 1, two - 1]区间保存1
        int i = 0;
        while (i < two) {
            if (nums[i] == 0) {
                zero++;
                swap(nums, zero, i);
                i++;
            } else if (nums[i] == 2) {
                two--;
                swap(nums, i, two);
            } else {
                if (nums[i] != 1) {
                    throw new IllegalArgumentException("不合法数字");
                }
                i++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        new Solution2().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
