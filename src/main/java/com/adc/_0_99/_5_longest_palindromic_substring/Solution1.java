package com.adc._0_99._5_longest_palindromic_substring;

/*
5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"


如果有多个最长回文子串，返回第一个
 */
public class Solution1 {
    // 暴力：双重循环穷举所有子串，然后找出最长的回文子串，时间复杂度O(n^3)，提交超时
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome(sub) && sub.length() > res.length()) {
                    res = sub;
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
