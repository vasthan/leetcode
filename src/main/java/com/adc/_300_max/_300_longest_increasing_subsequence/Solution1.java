package com.adc._300_max._300_longest_increasing_subsequence;

import java.util.ArrayList;
import java.util.List;

/**
 * 原题：https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 给定一个整数数组，找到其中最长严格递增子序列的长度
 *
 * 解法一：暴力回溯，搜索所有递增子序列的组合
 */
public class Solution1 {
    int lisLength = 0;
    List<Integer> lis = new ArrayList<>();
    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> seq = new ArrayList<>();
            seq.add(nums[i]);
            dfs(nums, i, seq);
        }
        return lisLength;
    }

    /**
     * 从index位置开始进行dfs，搜索递增子序列
     */
    private void dfs(int[] nums, int index, List<Integer> seq) {
        if (index == nums.length) {
            if (seq.size() > lisLength) {
                lisLength = seq.size();
                lis = new ArrayList<>(seq);
            }
            return;
        }
        if (nums[index] > seq.get(seq.size() - 1)) {
            // 遇到一个更大的数字，加入到序列中，继续递归
            seq.add(nums[index]);
            dfs(nums, index + 1, seq);

            // 回溯
            seq.remove(seq.size() - 1);
        }
        // 不加入序列
        dfs(nums, index + 1, seq);
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
//        s.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
//        System.out.println(s.lisLength);
//        System.out.println(s.lis);

        s.lengthOfLIS(new int[]{0,1,0,3,2,3});
        System.out.println(s.lisLength);
        System.out.println(s.lis);

//        s.lengthOfLIS(new int[]{7,7,7,7,7,7,7});
//        System.out.println(s.lisLength);
//        System.out.println(s.lis);
    }

}
