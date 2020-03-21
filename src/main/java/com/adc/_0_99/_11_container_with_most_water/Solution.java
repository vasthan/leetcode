package com.adc._0_99._11_container_with_most_water;

/**
 * 双指针法
 */
class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = (j - i) * Math.min(height[i], height[j]);
        while (i < j) {
            int hi = height[i];
            int hj = height[j];
            if (hi < hj) {
                while (i < j && height[i] <= hi) {
                    i++;
                }
            } else {
                while (i < j && height[j] <= hj) {
                    j--;
                }
            }
            if (i < j) {
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }
}
