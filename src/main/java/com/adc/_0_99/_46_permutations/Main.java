package com.adc._0_99._46_permutations;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new Solution().permute(nums);
        System.out.println(result);

        List<List<Integer>> result2 = new Solution2().permute(nums);
        System.out.println(result2);
    }
}
