package com.adc._0_99._5_longest_palindromic_substring;

public class Solution2 {

    // 从中间向两边扩展，找最长回文子串
    // 时间复杂度O(n^2)，空间复杂度O(1)，优于动态规划解法
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = findPalindrome(s, i, i);
            String s2 = findPalindrome(s, i, i + 1);  // i + 1会越界
            res = s1.length() > res.length() ? s1 : res;
            res = s2.length() > res.length() ? s2 : res;
        }
        return res;
    }


    /*
        在字符串s中，寻找以(i, j)为中点点的最长回文子串
        情况一：字符串长度是奇数
              i
        a b c d c b a
              j

        情况二：字符串长度是偶数
              i
        a b c d d c b a
                j
     */
    private String findPalindrome(String s, int i, int j) {
        // i, j向两边扩散
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, Math.min(s.length(), j));
    }
}
