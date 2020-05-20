package com.adc._0_99._46_permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        dfs(nums, 0);
        return res;
    }

    // 不使用used标记数组，将nums数组一分为二
    // [0, index - 1] 表示已经使用过的数字，[index, nums.length - 1] 表示未使用的数字
    private void dfs(int[] nums, int index) {
        if (index == nums.length) {
            res.add(toList(nums));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            dfs(nums, index + 1);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }
}
