package com.adc._0_99._46_permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列问题
 * 回溯法
 */
public class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        used = new boolean[nums.length];
        generatePermutation(nums, new ArrayList<>());
        return res;
    }


    private void generatePermutation(int[] nums, List<Integer> p) {
        if (p.size() == nums.length) {
            res.add(new ArrayList<>(p));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                p.add(nums[i]);
                generatePermutation(nums, p);
                p.remove(p.size() - 1);
                used[i] = false;
            }
        }
    }
}
