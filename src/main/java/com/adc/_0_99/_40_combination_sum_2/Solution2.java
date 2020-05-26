package com.adc._0_99._40_combination_sum_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基本和Solution一样，只是简化了剪枝2的步骤，不需要used[]数组了，空间复杂度上占了优势
 */
public class Solution2 {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>());
        return res;
    }

    private void dfs(int[] can, int start, int target, ArrayList<Integer> c) {
        if (target == 0) {
            res.add(new ArrayList<>(c));
            return;
        }

        for (int i = start; i < can.length; i++) {
            // 剪枝1 剩余的目标值已经不够用了
            if (can[i] > target)
                break;

            // 剪枝2 当前查看的元素和上一个查看的元素相同，且上一个元素没有处于使用中的状态
            // i > start 优雅的去除了同一层级的重复元素，但是保留了下一层级的重复元素，这个思路很牛逼
            if (i > start && can[i] == can[i - 1])
                continue;
            c.add(can[i]);
            dfs(can, i + 1, target - can[i], c);
            c.remove(c.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        System.out.println(res);
    }
}
