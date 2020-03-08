package com.adc.leetcode100.leetcode1_two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 一次遍历哈希表
 */
public class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int v = target - nums[i];
            if (map.containsKey(v)) {
                return new int[]{map.get(v), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
