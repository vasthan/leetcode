package com.adc.leetcode0_99.leetcode26_remove_duplicates_from_sorted_array;


import java.util.Arrays;

// 删除有序数组中的重复元素，每个元素只出一次
class MySolution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int i = 0, j = 1;
        while (j < n) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        // int[] nums = {1,1,1,2,2,2,3,3,3};
        int[] nums = {3,3,2};
        int n = new MySolution().removeDuplicates(nums);
        System.out.println(n);
        System.out.println(Arrays.toString(nums));
    }
}
