package com.adc._0_99._75_sort_colors;

import java.util.Arrays;

/**
 *     给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *     此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *     来源：力扣（LeetCode）
 *     链接：https://leetcode-cn.com/problems/sort-colors
 *     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution1 {
    // 计数排序，两趟遍历
    // 时间复杂度O(n)，空间复杂度O(k)，k表示元素的取值范围
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
        new Solution1().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
