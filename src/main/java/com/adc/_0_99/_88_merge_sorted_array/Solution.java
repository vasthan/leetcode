package com.adc._0_99._88_merge_sorted_array;

import java.util.Arrays;

/*
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 

示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

// 要求：时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    // 双指针从前往后，从小到大摆放
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 把nums1中的元素移动往后位移n
        System.arraycopy(nums1, 0, nums1, n, m);
        int i = n, j = 0, k = 0;
        while (i < m + n || j < n) {
            if (i == m + n) {
                nums1[k] = nums2[j++];
            } else if (j == n) {
                nums1[k] = nums1[i++];
            } else if (nums1[i] <= nums2[j]) {
                nums1[k] = nums1[i++];
            } else {
                nums1[k] = nums2[j++];
            }
            k++;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        new Solution().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
