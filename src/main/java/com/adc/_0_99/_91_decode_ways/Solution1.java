package com.adc._0_99._91_decode_ways;

import java.util.Arrays;

/**
 * 原题：https://leetcode-cn.com/problems/decode-ways/
 * 解法一：递归 + 记忆化
 */
public class Solution1 {
    private int[] memo;
    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return numDecodings(s, 0);
    }

    // 对于给定的字符串s和index，返回从[index, s.length() - 1]的子串的解码方法数
    private int numDecodings(String s, int index) {
        if (index == s.length()) {
            return 1;
        }
        // 跳过0开头的数字
        if (s.charAt(index) == '0') {
            return 0;
        }

        if (memo[index] == -1) {
            int cnt = 0;
            // 解码的数字范围[1,26]，每次只看1～2长度的数字
            for (int i = 1; i <= 2 && index + i <= s.length(); i++) {
                int num = Integer.parseInt(s.substring(index, index + i));
                if (num <= 26) {
                    cnt += numDecodings(s, index + i);
                }
            }
            memo[index] = cnt;
        }
        return memo[index];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().numDecodings("12"));
        System.out.println(new Solution1().numDecodings("226"));
    }
}
