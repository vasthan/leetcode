package com.adc._300_max._560_subarray_sum_equals_k;

import java.util.HashMap;
import java.util.Map;

class Solution {

    // 方法一：暴力解法，双重循环
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        // pre[i] = pre[i - 1] + nums[i]
        // 计算[j, i]中和为k的子数组数量，0 <= j <= i
        // pre[i] - pre[j - 1] = k --->  pre[j - 1] = pre[i] - k
        int count = 0;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre - k, map.getOrDefault(pre - k, 0) + 1);
        }
        return count;
    }
}