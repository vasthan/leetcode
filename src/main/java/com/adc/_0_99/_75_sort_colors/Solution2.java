package com.adc._0_99._75_sort_colors;

import java.util.Arrays;

// 计数排序，两趟遍历
// 时间复杂度O(n)，空间复杂度O(k)，k表示元素的取值范围
class Solution2 {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            if (num < 0 || num > 2) {
                throw new IllegalArgumentException("不合法数字");
            }
            count[num]++;
        }
        int index = 0;
        for (int i = 0; i < count[0]; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < count[1]; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < count[2]; i++) {
            nums[index++] = 2;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        new Solution2().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
