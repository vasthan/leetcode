package com.adc._0_99._47_permutations2;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列去重，在46题基础上，只是增加了一个结果集去重
 */
public class Solution {
    private List<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        res = new ArrayList<>();
        used = new boolean[nums.length];

        dfs(nums, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, List<Integer> p) {
        // 这里对结果集去重，是性能瓶颈
        if (p.size() == nums.length && !res.contains(p))
            res.add(List.copyOf(p));

        for (int i = 0; i < nums.length; i++)
            if (!used[i]) {
                used[i] = true;
                p.add(nums[i]);
                dfs(nums, p);
                used[i] = false;
                p.remove(p.size() - 1);
            }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> result = new Solution().permuteUnique(nums);
        System.out.println(result);
    }
}
