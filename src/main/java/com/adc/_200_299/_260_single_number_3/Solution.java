package com.adc._200_299._260_single_number_3;

import java.util.*;

/**
 * 原题：https://leetcode-cn.com/problems/single-number-iii/
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
 * 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        // 使用集合，记录出现过的数字
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (int num : set) {
            res[i++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] res1 = s.singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        int[] res2 = s.singleNumber(new int[]{0, 1});
        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
    }
}
