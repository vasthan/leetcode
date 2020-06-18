package com.adc._0_99._80_remove_duplicates_from_sorted_arrayII;

import java.util.Arrays;

public class SolutionBest {
    // 每个数字最多出现2次
    public int removeDuplicates(int[] nums) {
        if (nums == null) return -1;
        int k = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2])
                nums[k++] = nums[i];
        }
        return k;
    }

    // 每个数字最多出现n次
    public int removeDuplicates(int[] nums, int n) {
        if (nums == null) return -1;
        int k = n;
        for (int i = n; i < nums.length; i++) {
            if (nums[i] != nums[k - n])
                nums[k++] = nums[i];
        }
        return k;
    }

    public static void main(String[] args) {
        // int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        int[] nums = new int[]{3,3,2,1,1,1,1,0,0};

        System.out.println(new SolutionBest().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
