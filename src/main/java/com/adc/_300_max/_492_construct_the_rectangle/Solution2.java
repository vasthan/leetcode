package com.adc._300_max._492_construct_the_rectangle;

/**
 * 原题：https://leetcode-cn.com/problems/construct-the-rectangle/
 * 构造矩形
 *
 * 解法二：数学方法
 */
public class Solution2 {
    public int[] constructRectangle(int area) {
        // area = L * W，所以W能被area整除
        // L >= W
        // 所以：W * W <= L * W = area，得 W <= area ^ 0.5

        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            w--;
        }
        return new int[]{area / w, w};
    }
}
