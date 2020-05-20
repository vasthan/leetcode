package com.adc._0_99._47_permutations2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 参考 https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
 */
public class Solution2 {

    private List<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        used = new boolean[nums.length];
        // 先排序，为了后面的剪枝
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, List<Integer> ans) {
        if (ans.size() == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
                continue;
            used[i] = true;
            ans.add(nums[i]);
            dfs(nums, ans);
            used[i] = false;
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = solution.permuteUnique(nums);
        System.out.println(res);
    }
}
