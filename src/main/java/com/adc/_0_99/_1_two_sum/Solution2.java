package com.adc._0_99._1_two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 两次遍历哈希表
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = target - a;
            if (map.containsKey(b) && i != map.get(b)) {
                return new int[]{i, map.get(b)};
            }
        }
        return new int[0];
    }
}
