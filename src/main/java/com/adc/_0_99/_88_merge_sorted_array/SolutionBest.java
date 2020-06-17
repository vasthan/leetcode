package com.adc._0_99._88_merge_sorted_array;

public class SolutionBest {
    // 双指针从后往前，从大到小摆放，都不用挪nums1中的元素了
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0)
                nums1[k--] = nums2[j--];
            else if (j < 0)
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        }
    }
}
