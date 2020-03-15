package com.adc.leetcode200_299.leetcode283_move_zeroes;

import java.util.ArrayList;
import java.util.List;

// 遍历一遍数组，把所有不能等0的元素挨个放到一个临时数组
// 时间复杂度：O(n)，空间复杂度：O(n)
public class Solution1 {
    public void moveZeroes(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                tmp.add(nums[i]);
            }
        }
        for (int i = 0; i < tmp.size(); i++) {
            nums[i] = tmp.get(i);
        }
        for (int i = tmp.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-22, 0, 2, 0, 6, 15};
        new Solution1().moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}