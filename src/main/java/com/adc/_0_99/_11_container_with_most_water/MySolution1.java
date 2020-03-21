package com.adc._0_99._11_container_with_most_water;

/**
 * 暴力解法O(n2)
 */
class MySolution1 {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
            }
        }
        return max;
    }
}
