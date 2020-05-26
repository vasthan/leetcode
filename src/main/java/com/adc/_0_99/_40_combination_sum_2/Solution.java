package com.adc._0_99._40_combination_sum_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<List<Integer>> res;
    private boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        used = new boolean[candidates.length];
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
            if (can[i] > target) {
                // 剪枝1：剩余的目标值已经不够用了
                break;
            }
            if (i > 0 && can[i] == can[i - 1] && !used[i - 1]) {
                // 剪枝2：当前查看的元素和上一个查看的元素相同，且上一个元素没有处于使用中的状态
                continue;
            }
            used[i] = true;
            c.add(can[i]);
            dfs(can, i + 1, target - can[i], c);
            used[i] = false;
            c.remove(c.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        System.out.println(res);
    }
}
