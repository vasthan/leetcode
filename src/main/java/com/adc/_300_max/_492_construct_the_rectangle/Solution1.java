package com.adc._300_max._492_construct_the_rectangle;

/**
 * 原题：https://leetcode-cn.com/problems/construct-the-rectangle/
 * 构造矩形
 *
 * 解法一：双指针对撞
 */
public class Solution1 {
    public int[] constructRectangle(int area) {
        // 面积 = 长度 * 宽度
        // 长度 >= 宽度
        // 长度、宽度尽可能接近

        int[] res = {area, 1};
        int l = area, w = 1;
        while (l >= w) {
            int product = l * w;
            if (product == area) {
                if (l - w < res[0] - res[1]) {
                    res[0] = l;
                    res[1] = w;
                }
                l--;
                w++;
            } else if (product < area) {
                w++;
            } else {
                l--;
            }
        }
        return res;
    }
}
