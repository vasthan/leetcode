package com.adc._0_99._7_reverse_integer;

public class Solution {
    public int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        }
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        result = negative ? -result : result;
        if (result < -(1 << 31) || result > (1 << 31) - 1) {
            result = 0;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(123));
        System.out.println(new Solution().reverse(-123));
        System.out.println(new Solution().reverse(120));

        System.out.println(Integer.MAX_VALUE);
        System.out.println((1 << 31) - 1);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(- (1 << 31));
    }
}
