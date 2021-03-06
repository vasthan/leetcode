package com.adc._0_99._11_container_with_most_water;

/**
 * 双指针法
 */
class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 1)
            return 0;
        int i = 0, j = height.length - 1;
        int maxArea = area(height, i, j);
        while (i < j) {
            int hi = height[i];
            int hj = height[j];
            if (hi < hj)
                while (i < j && height[i] <= hi) i++;
            else
                while (i < j && height[j] <= hj) j--;
            if (i < j)
                maxArea = Math.max(maxArea, area(height, i, j));
        }
        return maxArea;
    }

    private int area(int[] height, int i, int j) {
        return (j - i) * Math.min(height[i], height[j]);
    }
}
