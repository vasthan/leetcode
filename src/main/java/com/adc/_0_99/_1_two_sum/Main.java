package com.adc._0_99._1_two_sum;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int[] result = new Solution3().twoSum(nums, 6);
        System.out.println(Arrays.toString(result));
    }
}