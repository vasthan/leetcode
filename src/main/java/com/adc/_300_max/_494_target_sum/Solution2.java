package com.adc._300_max._494_target_sum;

import java.util.HashMap;
import java.util.Map;

// 使用备忘录，减少重复运算
public class Solution2 {

    // map的键由(i, target)组成
    Map<String, Integer> memo;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        memo = new HashMap<>();
        return dfs(nums, 0, S);
    }

    private int dfs(int[] nums, int i, int target) {
        if (i == nums.length) {
            return target == 0 ? 1 : 0;
        }

        String key = i + "-" + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int res = dfs(nums, i + 1, target - nums[i]) + dfs(nums, i + 1, target + nums[i]);
        memo.put(key, res);
        return res;
    }
}
