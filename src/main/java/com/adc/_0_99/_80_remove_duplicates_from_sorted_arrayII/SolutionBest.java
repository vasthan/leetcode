package com.adc._0_99._80_remove_duplicates_from_sorted_arrayII;

import java.util.Arrays;

public class SolutionBest {
    public int removeDuplicates(int[] nums) {
        if (nums == null) throw new IllegalArgumentException("nums is null");
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n != nums[i - 2]) nums[i++] = n;
        }
        return i;
    }

    // 去重，每个元素最多出现k次
    public int removeDuplicates(int[] nums, int k) {
        if (nums == null) throw new IllegalArgumentException("nums is null");
        int i = 0;
        for (int n : nums) {
            if (i < k || n != nums[i - k]) nums[i++] = n;
        }
        return i;
    }

    public static void main(String[] args) {
        // int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        int[] nums = new int[]{3,3,2,1,1,1,1,0,0};

        System.out.println(new SolutionBest().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        // System.out.println(new SolutionBest().removeDuplicates(nums, 4));
        // System.out.println(Arrays.toString(nums));
    }
}
