package com.adc.leetcode0_99.leetcode27_remove_element;

// 我的解法：双指针-移动覆盖
// 时间复杂度：O(n)，空间复杂度：O(1)
public class MySolution1 {
    public int removeElement(int[] nums, int val) {
        // 区间[0, k)保存删除val后的新数组
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int newLength = new MySolution1().removeElement(nums, 2);
        for (int i = 0; i < newLength; i++) {
            System.out.println(nums[i]);
        }
    }
}
